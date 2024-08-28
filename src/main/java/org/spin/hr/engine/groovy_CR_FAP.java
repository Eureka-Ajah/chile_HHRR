/******************************************************************************
 * Product: ADempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2006-2017 ADempiere Foundation, All Rights Reserved.         *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * or (at your option) any later version.                                     *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * or via info@adempiere.net                                                  *
 * or https://github.com/adempiere/adempiere/blob/develop/license.html        *
 *****************************************************************************/

package org.spin.hr.engine;

import java.sql.Timestamp;
import java.util.Map;

import org.compiere.util.TimeUtil;
import org.eevolution.hr.model.MHRProcess;
import org.spin.hr.util.RuleInterface;



/** Generated Process for (groovy:CR_FAP CR_FAP)
 *  Description: Fecha de Años Trabajados
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class groovy_CR_FAP implements RuleInterface {

	String description = null;

	@Override
	public Object run(MHRProcess process, Map<String, Object> engineContext) {
		
		Timestamp result = null;
		description = null;
		//*** Calculo Fecha de Años Laborados ***
		
		//*** Declaración de Variables***
		// Extraemos la Fecha de Ingreso del Trabajador
		Timestamp inicio = ((Timestamp) engineContext.get("_DateStart"));
		//Extraemos el Concepto de Referencia Años de Servicio
	    Double servicio= process.getConcept ("CR_AS");
	    
		// Inicializamos la Variable de Resultado 
		Timestamp fecha;
		
		//*** Definición del Cálculo ***
		
		fecha = TimeUtil.addYears(inicio,servicio.intValue());
		
		// Imprime el Resultado
		 
		result=fecha;
		return result;
	}

	@Override
	public String getDescription() {
		return description;
	}
}