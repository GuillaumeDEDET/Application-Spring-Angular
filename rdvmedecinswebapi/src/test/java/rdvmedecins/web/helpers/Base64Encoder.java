package rdvmedecins.web.helpers;

import org.springframework.security.crypto.codec.Base64;

/**
 * Created by GuillaumeD on 21/04/2016.
 */
public class Base64Encoder {

    public static void main(String[] args){
        //on attend deux arguments : login password
        if(args.length != 2){
            System.out.println("Syntaxe : login password");
            System.exit(0);
        }
        // on récupère les deux arguments
        String chaine = String.format("%s:%s", args[0], args[1]);
        //on encode la chaîne
        byte[] data = Base64.encode(chaine.getBytes());
        //on afffiche son encodage Base64
        System.out.println(new String(data));
    }
}
