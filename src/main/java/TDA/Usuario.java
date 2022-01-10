package TDA;

public class Usuario {
    // Atributos
    private String nombreUsuario;
    private String contraseniaUsuario;

    // Constructor
    public Usuario crearUsuario(String nombreUsuario, String contraseniaUsuario){
        this.nombreUsuario = nombreUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
        return this;
    }

    // Metodos
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    public String getContraseniaUsuario(){
        return contraseniaUsuario;
    }

}
