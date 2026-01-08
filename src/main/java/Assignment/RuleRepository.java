package Assignment;

import Assignment.OutputConstraints.*;

import java.util.ArrayList;
import java.util.List;

public class RuleRepository {

  private final List<VisaRule> rules;

  public RuleRepository(List<VisaRule> rules) {
    this.rules = rules == null ? new ArrayList<>() : new ArrayList<>(rules);
  }

  public List<VisaRule> getAllRules() {
    return new ArrayList<>(rules);
  }
}