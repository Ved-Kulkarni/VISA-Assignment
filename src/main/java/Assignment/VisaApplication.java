package Assignment;

import Assignment.InputConstraints.*;
import Assignment.DTO.VisaDecision;

import java.util.Scanner;

public class VisaApplication {

  public static void main(String[] args) {

    try {
      RuleLoader loader = new RuleLoader();
      RuleRepository repository = new RuleRepository(loader.load("src/main/java/Assignment/rules.json").rules);

      VisaRuleEvaluator evaluator = new VisaRuleEvaluator(repository);

      Scanner s = new Scanner(System.in);

      System.out.print("Enter destination country : ");
      Country destinationCountry = Country.valueOf(s.nextLine().toUpperCase());

      System.out.print("Enter passport country : ");
      Country passportCountry = Country.valueOf(s.nextLine().toUpperCase());

      System.out.print("Enter travel purpose : ");

      TravelPurpose travelPurpose = TravelPurpose.valueOf(s.nextLine().toUpperCase());
      System.out.print("Enter stay duration (days): ");

      int stayDuration = s.nextInt();

      VisaDecision decision = evaluator.evaluate(destinationCountry, passportCountry, travelPurpose, stayDuration);

      System.out.println("\n=== VISA DECISION ===");
      System.out.println("Visa Required  : " + decision.isVisaRequired());
      System.out.println("Visa Type      : " + decision.getVisaType());
      System.out.println("Documents      : " + decision.getDocuments());
      System.out.println("Processing Days: " + decision.getEstimatedProcessingDays());
      System.out.println("Warnings       : " + decision.getWarnings());

      s.close();

    } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
