package com.sistema.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity//vira um entidade do banco

public class Funcionario implements Serializable, UserDetails {//
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFunc;

    @Column
    private String nomeFunc;
    private String sobrenomeFunc;
    private String username;
    private String password;
    private String foneFunc;
    private String ruaFunc;
    private String cepFunc;
    private String bairroFunc;
    private int numeroFunc;
    private String generoFunc;
    private String cpfFunc;
    private String nascimentoFunc;
    private String estadoFunc;
    private String cidadeFunc;

    @ManyToMany
    @JoinTable(name="funcionario_roles",joinColumns = @JoinColumn(name="funcionario_id",referencedColumnName = "idFunc"),
    inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "nomeRole"))


//    @ManyToMany
//    @JoinTable(
//            name = "usuarios_roles",
//            joinColumns = @JoinColumn(
//                    name = "usuario_id", referencedColumnName = "login"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "nomeRole"))
    private List<Role> roles;

//    public Funcionario(Long idFunc, String nomeFunc, String sobrenomeFunc, String username, String password, String foneFunc, String ruaFunc, String cepFunc, String bairroFunc, int numeroFunc, String generoFunc, String cpfFunc, String nascimentoFunc, String estadoFunc, String cidadeFunc) {
//        this.idFunc = idFunc;
//        this.nomeFunc = nomeFunc;
//        this.sobrenomeFunc = sobrenomeFunc;
//        this.username = username;
//        this.password = password;
//        this.foneFunc = foneFunc;
//        this.ruaFunc = ruaFunc;
//        this.cepFunc = cepFunc;
//        this.bairroFunc = bairroFunc;
//        this.numeroFunc = numeroFunc;
//        this.generoFunc = generoFunc;
//        this.cpfFunc = cpfFunc;
//        this.nascimentoFunc = nascimentoFunc;
//        this.estadoFunc = estadoFunc;
//        this.cidadeFunc = cidadeFunc;
//    }

    public Long getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Long  idFunc) {
        this.idFunc = idFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getSobrenomeFunc() {
        return sobrenomeFunc;
    }

    public void setSobrenomeFunc(String sobrenomeFunc) {
        this.sobrenomeFunc = sobrenomeFunc;
    }

//    public String getUsername() {
//        return username;
//    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public String getpassword() {
//        return password;
//    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getFoneFunc() {
        return foneFunc;
    }

    public void setFoneFunc(String foneFunc) {
        this.foneFunc = foneFunc;
    }

    public String getRuaFunc() {
        return ruaFunc;
    }

    public void setRuaFunc(String ruaFunc) {
        this.ruaFunc = ruaFunc;
    }

    public String getCepFunc() {
        return cepFunc;
    }

    public void setCepFunc(String cepFunc) {
        this.cepFunc = cepFunc;
    }

    public String getBairroFunc() {
        return bairroFunc;
    }

    public void setBairroFunc(String bairroFunc) {
        this.bairroFunc = bairroFunc;
    }

    public int getNumeroFunc() {
        return numeroFunc;
    }

    public void setNumeroFunc(int numeroFunc) {
        this.numeroFunc = numeroFunc;
    }

    public String getGeneroFunc() {
        return generoFunc;
    }

    public void setGeneroFunc(String generoFunc) {
        this.generoFunc = generoFunc;
    }

    public String getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(String cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public String getNascimentoFunc() {
        return nascimentoFunc;
    }

    public void setNascimentoFunc(String nascimentoFunc) {
        this.nascimentoFunc = nascimentoFunc;
    }

    public String getEstadoFunc() {
        return estadoFunc;
    }

    public void setEstadoFunc(String estadoFunc) {
        this.estadoFunc = estadoFunc;
    }

    public String getCidadeFunc() {
        return cidadeFunc;
    }

    public void setCidadeFunc(String cidadeFunc) {
        this.cidadeFunc = cidadeFunc;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;//retorna o email pois esse é o campo que vai ser pedido no login
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}
