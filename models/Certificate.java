package models;

import utils.CodeGenerator;

public class Certificate {
    private String code;
    private Participant participant;
    private Activity activity;

    public Certificate(Participant participant, Activity activity) {
        this.setCode(CodeGenerator.generate());
        this.setParticipant(participant);
        this.setActivity(activity);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null) return;

        this.code = code;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        if (participant == null) return;

        this.participant = participant;
    }

    public Activity getActivity() {
        return activity;
    }
    public void setActivity(Activity activity) {
        if (activity == null) return;

        this.activity = activity;
    }
}
