import com.google.gson.annotations.SerializedName;

public class Taxa {
    private double valor;

    public Taxa(taxaJson minhaTaxa) {
        this.valor = Double.valueOf(minhaTaxa.conversion_result());
    }

    @Override
    public String toString() {
        return "" + valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

