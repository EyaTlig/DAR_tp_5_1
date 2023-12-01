package rmiClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConversionClient {
    public static void main(String[] args) {
        try {
            // Obtention du registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Récupération de l'objet distant à l'aide du nom
            IConversion conversionObj = (IConversion) registry.lookup("ConversionService");

            // Utilisation de l'objet distant
            double montantConverti = conversionObj.convertirMontant(100.0);

            System.out.println("Montant converti : " + montantConverti);
        } catch (Exception e) {
            System.err.println("Erreur côté client : " + e.toString());
            e.printStackTrace();
        }
    }
}

