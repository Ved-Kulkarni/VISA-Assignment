package Assignment.DTO;

import Assignment.OutputConstraints.*;

import java.util.ArrayList;
import java.util.List;

public final class VisaDecision {

    private final boolean visaRequired;
    private final VisaType visaType;
    private final List<DocumentType> documents;
    private final int estimatedProcessingDays;
    private final List<String> warnings;

    public VisaDecision(boolean visaRequired, VisaType visaType, List<DocumentType> documents, int estimatedProcessingDays, List<String> warnings) {
        this.visaRequired = visaRequired;
        this.visaType = visaType;
        this.documents = documents == null ? new ArrayList<>() : new ArrayList<>(documents);
        this.estimatedProcessingDays = estimatedProcessingDays;
        this.warnings = warnings == null ? new ArrayList<>() : new ArrayList<>(warnings);
    }

    public boolean isVisaRequired() {
        return visaRequired;
    }

    public VisaType getVisaType() {
        return visaType;
    }

    public List<DocumentType> getDocuments() {
        return new ArrayList<>(documents);
    }

    public int getEstimatedProcessingDays() {
        return estimatedProcessingDays;
    }

    public List<String> getWarnings() {
        return new ArrayList<>(warnings);
    }
}
