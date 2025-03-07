package dtos;

/**
 * DTO para representar los datos de un usuario.
 */
public class UsuarioDto {
    private Long id;
    private String nombreCompleto;
    private String movil;
    private String correoElectronico;
    private String tipoUsuario;
    private String contrasena;
    private String foto;

    /**
     * Obtiene el ID del usuario.
     * @return el ID del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     * @param id el ID del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del usuario.
     * @return el nombre completo del usuario.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del usuario.
     * @param nombreCompleto el nombre completo del usuario.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el número de móvil del usuario.
     * @return el número de móvil del usuario.
     */
    public String getMovil() {
        return movil;
    }

    /**
     * Establece el número de móvil del usuario.
     * @param movil el número de móvil del usuario.
     */
    public void setMovil(String movil) {
        this.movil = movil;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return el correo electrónico del usuario.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param correoElectronico el correo electrónico del usuario.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene el tipo de usuario.
     * @return el tipo de usuario.
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Establece el tipo de usuario.
     * @param tipoUsuario el tipo de usuario.
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return la contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contrasena la contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene la foto del usuario.
     * @return la foto del usuario.
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Establece la foto del usuario.
     * @param foto la foto del usuario.
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }
}