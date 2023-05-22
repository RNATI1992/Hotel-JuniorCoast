package sample.Models;

public class Reserva {
    Integer numBungalow;
    String dniClient;
    String dniRecepcionista;
    String dataIngres;
    String horaIngres;
    String dataSortida;
    String horaSortida;
    Integer preuTotal;
    String estat;
    Integer numReserva;

    public Reserva(Integer id,Integer numBungalow, String dniClient, String dniRecepcionista, String dataIngres, String horaIngres, String dataSortida, String horaSortida, Integer preuTotal, String estat) {
        this.numReserva = id;
        this.numBungalow = numBungalow;
        this.dniClient = dniClient;
        this.dniRecepcionista = dniRecepcionista;
        this.dataIngres = dataIngres;
        this.horaIngres = horaIngres;
        this.dataSortida = dataSortida;
        this.horaSortida = horaSortida;
        this.preuTotal = preuTotal;
        this.estat = estat;
    }

    public Reserva(Integer numBungalow) {
        this.numBungalow = numBungalow;
    }

    public Reserva (String dni_recepcionista){
        this.dniRecepcionista = dniRecepcionista;
    }

    public Integer getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(Integer id) {
        this.numReserva= id;
    }

    public Integer getNumBungalow() {
        return numBungalow;
    }

    public void setNumBungalow(Integer numBungalow) {
        this.numBungalow = numBungalow;
    }

    public String getDniClient() {
        return dniClient;
    }

    public void setDniClient(String dniClient) {
        this.dniClient = dniClient;
    }

    public String getDniRecepcionista() {
        return dniRecepcionista;
    }

    public void setDniRecepcionista(String dniRecepcionista) {
        this.dniRecepcionista = dniRecepcionista;
    }

    public String getDataIngres() {
        return dataIngres;
    }

    public void setDataIngres(String dataIngres) {
        this.dataIngres = dataIngres;
    }

    public String getHoraIngres() {
        return horaIngres;
    }

    public void setHoraIngres(String horaIngres) {
        this.horaIngres = horaIngres;
    }

    public String getDataSortida() {
        return dataSortida;
    }

    public void setDataSortida(String dataSortida) {
        this.dataSortida = dataSortida;
    }

    public String getHoraSortida() {
        return horaSortida;
    }

    public void setHoraSortida(String horaSortida) {
        this.horaSortida = horaSortida;
    }

    public Integer getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(Integer preuTotal) {
        this.preuTotal = preuTotal;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }
}

