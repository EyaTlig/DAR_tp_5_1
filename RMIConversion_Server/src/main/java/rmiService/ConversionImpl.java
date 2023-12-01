package rmiService;

public class ConversionImpl implements IConversion {
    @Override
    public double convertirMontant(double mt) {
        // Implémentation de la conversion ici
        // Retournez le résultat de la conversion
        return mt * 5;
    }
}