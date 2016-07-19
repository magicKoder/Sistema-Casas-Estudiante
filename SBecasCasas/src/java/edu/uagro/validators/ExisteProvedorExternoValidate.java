/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.validators;

import edu.uagro.dao.Tbl_ArrendadorDAO;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Antonio18244
 */
@FacesValidator (value = "existeProvedorExternoValidate")
public class ExisteProvedorExternoValidate implements Validator{


    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        int claveEmpleado = Integer.parseInt(texto);
        Tbl_ArrendadorDAO dao = new Tbl_ArrendadorDAO();
        if(dao.validarExterno(claveEmpleado)==false){
            FacesMessage message = new FacesMessage();
            message.setSummary("El numero de proveedor no se encuentra en el sistema...");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    
    }
}
