package simulation.environment;

public class Weather {

    private Radiation radiation;

    private int deltaVote;
    private int alphaVote;

    public Weather() {
        this.radiation =Radiation.NONE;
    }

    public void calculate() {
        if(alphaVote >= deltaVote+3){
            this.radiation = Radiation.ALPHA;
        } else if (deltaVote >= alphaVote+3){
            this.radiation = Radiation.DELTA;
        } else {
            this.radiation = Radiation.NONE;
        }
        this.deltaVote=0;
        this.alphaVote=0;
    }

    public void addDeltaVote(int deltaVote) {
        this.deltaVote += deltaVote;
    }

    public void addAlphaVote(int alphaVote) {
        this.alphaVote += alphaVote;
    }

    public int getDeltaVote() {
        return deltaVote;
    }

    public int getAlphaVote() {
        return alphaVote;
    }

    public Radiation getRadiation() {
        return radiation;
    }

    public void setRadiation(Radiation radiation) {
        this.radiation = radiation;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "radiation=" + radiation +
                ", deltaVote=" + deltaVote +
                ", alphaVote=" + alphaVote +
                '}';
    }
}
