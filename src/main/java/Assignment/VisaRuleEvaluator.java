package Assignment;

import Assignment.InputConstraints.*;
import Assignment.OutputConstraints.*;
import Assignment.DTO.VisaDecision;

import java.util.ArrayList;
import java.util.List;

public class VisaRuleEvaluator {

    private final RuleRepository ruleRepository;

    public VisaRuleEvaluator(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    private VisaType resolveVisaType(TravelPurpose purpose, VisaRule rule) {

    if (rule.getVisaType() != VisaType.NONE) {
        return rule.getVisaType();
    }

    switch (purpose) {
        case TOURISM:
            return VisaType.TOURIST;
        case BUSINESS:
            return VisaType.BUSINESS;
        case STUDY:
            return VisaType.STUDENT;
        default:
            return VisaType.NONE;
    }
}

    public VisaDecision evaluate(Country visitingCountry, Country passportCountry, TravelPurpose travelPurpose, int stayDuration) 
    {

        List<VisaRule> matches = new ArrayList<>();

        for (VisaRule rule : ruleRepository.getAllRules()) {
            boolean countryMatch = rule.getCountry() == Country.ANY || rule.getCountry() == visitingCountry;

            boolean passportMatch = rule.getPassportCountry() == Country.ANY || rule.getPassportCountry() == passportCountry;

            boolean purposeMatch = rule.getTravelPurpose() == TravelPurpose.ANY || rule.getTravelPurpose() == travelPurpose;

            boolean durationMatch = stayDuration <= rule.getStayDuration();

            if (countryMatch && passportMatch && purposeMatch && durationMatch) {
                matches.add(rule);
            }
        }

        if (matches.isEmpty() || visitingCountry == null || passportCountry == null || travelPurpose == null) {
            return new VisaDecision(true, VisaType.UNKNOWN, new ArrayList<>(), 0, List.of("No matching visa rule found")
            );
        }

        if(Country.INDIA == visitingCountry && passportCountry == Country.INDIA){
            return new VisaDecision(false, VisaType.NONE, new ArrayList<>(), 0, List.of("No visa required for domestic travel"));
        }

        if (matches.size() > 1) {
            return new VisaDecision(true, VisaType.NONE, new ArrayList<>(), 0, List.of("Multiple visa rules matched. Manual review required."));
        }

        VisaRule rule = matches.get(0);

        VisaType finalVisaType = resolveVisaType(travelPurpose, rule);

        return new VisaDecision(
            rule.isVisaRequired(),
            finalVisaType,
            rule.getDocumentType(),
            rule.getEstimatedProcessingDays(),
            rule.getWarnings()
        );
    }
}
