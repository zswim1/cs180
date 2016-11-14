/**
 * Created by Zach on 10/29/2016.
 */

//fix exception throw in removeResidence

public class ResidenceListings {
    private int numResidences;
    private int maxResidences;
    private Residence[] residences;
    private boolean removed = false;

    public ResidenceListings(){
        numResidences = 0;
        maxResidences = 10;
        residences = new Residence[maxResidences];
    }

    public void addResidence(Residence residence){
        if (numResidences >= maxResidences){
            maxResidences = maxResidences*2;
            Residence[] newArray = new Residence[maxResidences];
            for (int i = 0; i< numResidences;i++){
                newArray[i] = residences[i];
            }
            residences = newArray;
        }
        residences[numResidences] = residence;
        numResidences ++;
    }

    public void removeResidence(Residence residence) throws NoSuchResidenceException {
        for (int i = 0; i< numResidences; i++){
            if (residences[i].equals(residence)){
                removed = true;
                for (int j = i; j<numResidences-1;j++){
                    residences[j] = residences[j+1];
                }
            }
        }
        if (removed){
            numResidences --;
            residences[numResidences] = null;
        }
        else{
            throw new NoSuchResidenceException("Residence not found");
        }

    }

    public Residence findResidenceByAddress(String address){
        for (int i=0;i<numResidences;i++){
            if (residences[i].getAddress().equals(address)){
                return residences[i];
            }
        }
        return null;
    }

    public int getNumResidences(){
        return numResidences;
    }

    public int getMaxResidences(){
        return maxResidences;
    }

    public Residence[] getResidences(){
        return residences;
    }
}
