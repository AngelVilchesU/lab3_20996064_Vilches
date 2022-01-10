package TDA;

public class Usuario {
    // Atributos
    private String nombreUsuario;
    private String contraseniaUsuario;
    private int sesion;

    // Constructor
    public Usuario Usuario(String nombreUsuario, String contraseniaUsuario, int sesion){
        this.nombreUsuario = nombreUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
        this.sesion = sesion;
        return this;
    }

    // Metodos
    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public String getContraseniaUsuario(){
        return contraseniaUsuario;
    }

    public int getSesion(){
        return sesion;
    }

    public void setSesion(int sesion) {
        this.sesion = sesion;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", contraseniaUsuario='" + contraseniaUsuario + '\'' +
                ", sesion=" + sesion +
                '}';
    }


}
