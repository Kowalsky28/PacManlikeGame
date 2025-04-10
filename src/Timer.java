import javax.swing.*;

public class Timer {
    private int secondsCounter;
    private int minuteCounter;
    private JLabel timeLabel;
    public Timer(){
        this.secondsCounter = 0;
        this.minuteCounter = 0;
        this.timeLabel = new JLabel();
        timeLabel.setOpaque(true);
        timeLabel.setText(formattedTime());
    }
    public synchronized void countTime(){
        this.secondsCounter++;
    }
    public String formattedTime(){
        if(0<=this.secondsCounter && this.secondsCounter < 10)
            return "0"+this.minuteCounter+":0"+this.secondsCounter;
        else if(10 <= this.secondsCounter && this.secondsCounter < 60)
            return "0"+this.minuteCounter+":"+this.secondsCounter;
        else if(this.secondsCounter %60==0){
            this.setMinuteCounter(this.getMinuteCounter()+1);
            this.setSecondsCounter(0);
            if(this.minuteCounter < 10)
                return "0"+this.minuteCounter+":00";
            else
                return this.minuteCounter+":00";
        }
        return "nie pyklo";
    }
    public synchronized void refreshClock(){
        timeLabel.setText(formattedTime());
        timeLabel.repaint();
    }

    public int getSecondsCounter() {
        return secondsCounter;
    }
    public void setSecondsCounter(int secondsCounter) {
        this.secondsCounter = secondsCounter;
    }
    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }
    public int getMinuteCounter() {
        return minuteCounter;
    }

    public void setMinuteCounter(int minuteCounter) {
        this.minuteCounter = minuteCounter;
    }
}
