package com.empresa.microservicios.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.microservicios.models.Factura;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

	@PostMapping
	public String crearFactura(@RequestBody Factura factura) { // Con esto ya me ha recogido toda la info del body
																// introducida

		// Recuperar los datos de la factura
		System.out.println(factura.getConcepto());

		// Insertar la factura en base de datos
		// Código responsable de insertar la factura en la base de datos...

		return "Todo OK";
	}

	@GetMapping("/{facturaId}")
	public Factura recuperarFactura(@PathVariable String facturaId) {

		System.out.println(facturaId);
		// Recuperar de la base de datos la entidad asociada a facturaId
		// ... CÓDIGO

		// Crear un objeto de prueba
		Factura f = new Factura();
		f.setConcepto("Servicio de consultoria");
		f.setImporte(247362);
		f.setCif("31974338");

		return f;

		// Creamos un objeto de tipo Factura y para que no se queje creamos una factura
		// vacía
	}
	
	
	@DeleteMapping("/{facturaId}")
	public String borrarFactura(@PathVariable String facturaId) {  //Se pone string porque sólo envia un menzaje al terminar de borrarlo

		System.out.println(facturaId);
		// Borrar de la base de datos la entidad asociada a facturaId
		//...CODIGO
		

		return "La factura ha sido eliminada correctamente!";
	}

}
