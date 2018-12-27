/**
 *  BackgroundCheck Class
 *  This class represents a Background Check
 *
 * @author Jill Eliceiri
 * @author Sonia Coile
 */

public class BackgroundCheck {

    private String hasCriminalHistory;
    private String isDangerToSelfOrOthers;
    private String canHandleOwnAffairs;

    public String getCriminalHistory() {
        return hasCriminalHistory;
    }

    public void setCriminalHistory(String hasCriminalHistory) {
        this.hasCriminalHistory = hasCriminalHistory;
    }

    public String getDangerToSelfOrOthers() {
        return isDangerToSelfOrOthers;
    }

    public void setDangerToSelfOrOthers(String dangerToSelfOrOthers) {
        isDangerToSelfOrOthers = dangerToSelfOrOthers;
    }

    public String getCanHandleOwnAffairs() {
        return canHandleOwnAffairs;
    }

    public void setCanHandleOwnAffairs(String canHandleOwnAffairs) {
        this.canHandleOwnAffairs = canHandleOwnAffairs;
    }

    public String toString(){
        return ("Criminal History: " + getCriminalHistory() + ",\tDangerous: " + getDangerToSelfOrOthers()
            + ",\tAble to Handle Own Affairs: " + getCanHandleOwnAffairs() + "\n");
    }
}
