probarSeleccionar();
Dimv b;
dimv a;
dimv z:g('01/12/199',10*51,"holisss");
imprimir(z);
Dimv h{2*4};
a:"popote";
b:-6*10;
imprimir(b);
a:"hola mundo";
dimv c{5}:{"hola","pedrito",25,2*3,":p"};
c{0}:"hola"+" mundo"+" bello";
b++;
b++;
b++;
b--;
dimv op: documento.obtener("nuevoSpinner");
dimv op2: documento.obtener("botonPanel");
dimv op3: documento.obtener("EnlaCed");
op2.setElemento("ancho","1000");
documento.obtener("botonMi").setElemento("ancho","20");
documento.obtener("botonPanel").setElemento("alto","10");
imprimir("valor de b "+b);
imprimir("valor de b simulado "+ (b+3)++);
imprimir("valor de b simulado "+ b--);
imprimir("valor de b "+b);
dImV fecha: '01/12/199';
mensaje("Esto es"+(2*4)+"una prueba");
imprimir('01/12/1990');
imprimir("hola mundo");
imprimir("alinita bonita "+'01/12/1992'+" "+2*5);

si(5<10){
dimv c:"esto es una cadena";
imprimir("tamanho del arreglo  C"+ c.conTeo);
imprimir("Elementos del arreglo  C"+ c.aTEXto());
imprimir ("La posicion no 1 del arreglo c "+c{1});
imprimir("hola");
dimv a:"lizzz";
a:2598;
b:96;
imprimir("este es el valor de b "+b);
c{2}:"cambio";
b--;
}sino{
imprimir("adios");
}
b:1;
mientrAs(b<10){
dimv pedir:" ejemplo "+b;
si(b==5){
c{1}:"cambio2";
b:"exito";
imprimir("este es el valor de b "+b);

detener;
}
imprimir(pedir+" "+"vuelta no "+b);
b++;
}


funcion probarSeleccionar(){
	selecciona(2*5){}
	
	selecciona(100){
	   caso 5:
			imprimir("este es el 5");
		 caso 10:
			imprimir("este es el 5");
		caso 10*2:
			imprimir("este es el 5");
		caso 6:
			imprimir("este es el 5");
			caso 6:
			imprimir("este es el 5");
			detener;
			caso 6:
			imprimir("no debe salir");
			caso 6:
			imprimir("no debe salir");
			defecto:
			imprimir("muestra un defecto");

	}
}



funcion g(valor2,numero2,cadena2){
para(i:0;i<10;++){
imprimir("valor de "+i);
}
imprimir("llame a una funcion y me ire a dormir "+valor2+numero2+cadena2);
retornar (10+3)+" este es un valor de retornor";
imprimir("no se dene imprmir");
imprimir("esto tampoco");
}

funcion factorial(n){
  si(n==0){
   retornar(1);
  }sino{
    retornar (n*(factorial(n-1)));
  }

}



