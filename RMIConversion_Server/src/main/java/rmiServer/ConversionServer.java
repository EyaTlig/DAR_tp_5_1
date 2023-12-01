package rmiServer;

import rmiService.ConversionImpl;
import rmiService.IConversion;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ConversionServer {
    public static void main(String[] args) {
        try {
            // Création de l'objet distant
            IConversion conversionObj = new ConversionImpl();

            // Exportation de l'objet distant
            IConversion stub = (IConversion) UnicastRemoteObject.exportObject(conversionObj, 0);

            // Création du registre RMI
            Registry registry = LocateRegistry.createRegistry(1099);

            // Liaison de l'objet distant avec le nom "ConversionService"
            registry.rebind("ConversionService", stub);

            System.out.println("Serveur prêt...");
        } catch (Exception e) {
            System.err.println("Erreur côté serveur : " + e.toString());
            e.printStackTrace();
        }
    }
}
