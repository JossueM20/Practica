package com.productos.model;


public class Tarjeta {
	private int id;
	private String num_tar;
	private String nombre;
	private String fecha_vencimiento;
	private int cantidad;


	public Tarjeta() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	@Override
	public String toString() {
		return nombre;
	}

	public String getNum_tar() {
		return num_tar;
	}

	public void setNum_tar(String num_tar) {
		this.num_tar = num_tar;
	}

	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

}
