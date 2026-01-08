package Assignment.OutputConstraints;

import Assignment.InputConstraints.Country;
import Assignment.InputConstraints.TravelPurpose;
import java.util.List;

public class VisaRule {

    private Country Country;
    private Country PassportCountry;
    private TravelPurpose TravelPurpose;
    private int StayDuration;

    private boolean VisaRequired;
    private VisaType VisaType;
    private List<DocumentType> DocumentType;
    private int EstimatedProcessingDays;
    private List<String> Warnings;

    // ----- GETTERS -----
    public Country getCountry() {
        return Country;
    }

    public Country getPassportCountry() {
        return PassportCountry;
    }

    public TravelPurpose getTravelPurpose() {
        return TravelPurpose;
    }

    public int getStayDuration() {
        return StayDuration;
    }

    public boolean isVisaRequired() {
        return VisaRequired;
    }

    public VisaType getVisaType() {
        return VisaType;
    }

    public List<DocumentType> getDocumentType() {
        return DocumentType;
    }

    public int getEstimatedProcessingDays() {
        return EstimatedProcessingDays;
    }

    public List<String> getWarnings() {
        return Warnings;
    }

    // ----- SETTERS (THIS IS THE FIX) -----
    public void setCountry(Country country) {
        this.Country = country;
    }

    public void setPassportCountry(Country passportCountry) {
        this.PassportCountry = passportCountry;
    }

    public void setTravelPurpose(TravelPurpose travelPurpose) {
        this.TravelPurpose = travelPurpose;
    }

    public void setStayDuration(int stayDuration) {
        this.StayDuration = stayDuration;
    }

    public void setVisaRequired(boolean visaRequired) {
        this.VisaRequired = visaRequired;
    }

    public void setVisaType(VisaType visaType) {
        this.VisaType = visaType;
    }

    public void setDocumentType(List<DocumentType> documentType) {
        this.DocumentType = documentType;
    }

    public void setEstimatedProcessingDays(int estimatedProcessingDays) {
        this.EstimatedProcessingDays = estimatedProcessingDays;
    }

    public void setWarnings(List<String> warnings) {
        this.Warnings = warnings;
    }
}
