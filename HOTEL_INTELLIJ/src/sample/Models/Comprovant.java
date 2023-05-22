package sample.Models;

public class Comprovant {
    String  nom;
    String  cognoms;
    String  dniClientComprovant;
    String  dataSortidaComprovant;
    String  horaSortidaComprovant;
    Integer preuTotalComprovant;
    Integer numBungalowComprovant;

    Integer numReserva;

    public Comprovant ( Integer numReserva, String dniClient, String nom,String cognoms,String dataSortida,String horaSortida,Integer preuTotal, Integer numBungalow){
        this.dniClientComprovant = dniClient;
        this.nom = nom;
        this.cognoms = cognoms;
        this.dataSortidaComprovant = dataSortida;
        this.horaSortidaComprovant = horaSortida;
        this.preuTotalComprovant = preuTotal;
        this.numBungalowComprovant = numBungalow;
        this.numReserva = numReserva;
    }

    public String getNom (){
        return nom;
    }

    public void setNom (String nom){
        this.nom = nom;
    }

    public String getCognoms (){
        return cognoms;
    }

    public void setCognoms (String cognoms){
        this.cognoms = cognoms;
    }

    public String getDniClientComprovant (){
        return dniClientComprovant;
    }

    public void setDniClientComprovant (String dniClientComprovant){
        this.dniClientComprovant = dniClientComprovant;
    }

    public String getDataSortidaComprovant (){
        return dataSortidaComprovant;
    }

    public void setDataSortidaComprovant (String dataSortidaComprovant){
        this.dataSortidaComprovant = dataSortidaComprovant;
    }

    public String getHoraSortidaComprovant (){
        return horaSortidaComprovant;
    }

    public void setHoraSortidaComprovant (String horaSortidaComprovant){
        this.horaSortidaComprovant = horaSortidaComprovant;
    }

    public Integer getPreuTotalComprovant (){
        return preuTotalComprovant;
    }

    public void setPreuTotalComprovant (Integer preuTotalComprovant){
        this.preuTotalComprovant = preuTotalComprovant;
    }

    public Integer getNumBungalowComprovant (){
        return numBungalowComprovant;
    }



    public void setNumBungalowComprovant (Integer numBungalowComprovant){
        this.numBungalowComprovant = numBungalowComprovant;
    }

    public Integer getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(Integer numReserva) {
        this.numReserva = numReserva;
    }



}
