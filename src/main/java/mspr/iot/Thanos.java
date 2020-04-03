package mspr.iot;

public class Thanos {

    int nbPierreInfinite;
    boolean missionReussi;

    public Thanos(int nbPierreInfinite) {
        if (nbPierreInfinite <= 5) {
            this.nbPierreInfinite = nbPierreInfinite;
        } else {
            this.nbPierreInfinite = 5;
        }
        this.missionReussi = false;
    }

    public void gagnePierre() {
        if (this.nbPierreInfinite < 5) {
            this.nbPierreInfinite++;
        }
    }

    public int claquementDeDoigts(int nbPopulation) {
        int result;
        if (this.nbPierreInfinite == 5) {
            result = nbPopulation / 2;
            this.missionReussi = true;
        } else {
            result = nbPopulation;
        }
        return result;
    }

    public int getNbPierreInfinite() {
        return nbPierreInfinite;
    }

    public void setNbPierreInfinite(int nbPierreInfinite) {
        this.nbPierreInfinite = nbPierreInfinite;
    }

    public boolean isMissionReussi() {
        return missionReussi;
    }

    public void setMissionReussi(boolean missionReussi) {
        this.missionReussi = missionReussi;
    }

    @Override
    public String toString() {
        return "Thanos [nbPierreInfinite=" + nbPierreInfinite + ", missionReussi=" + missionReussi + "]";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.nbPierreInfinite;
        hash = 41 * hash + (this.missionReussi ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Thanos other = (Thanos) obj;
        if (this.nbPierreInfinite != other.nbPierreInfinite) {
            return false;
        }
        if (this.missionReussi != other.missionReussi) {
            return false;
        }
        return true;
    }

}
