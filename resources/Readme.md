Bodega - Semáforo
===================
Nombre| Código
--- | --- | ---
|Jose Osorio | 12203012	
| Bryan Perez| 12203030
Un semáforo es una variable especial (o tipo abstracto de datos) que constituye el método clásico para restringir o permitir el acceso a recursos compartidos (por ejemplo, un recurso de almacenamiento del sistema o variables del código fuente) en un entorno de multiprocesamiento (en el que se ejecutarán varios procesos concurrentemente).[^semaforo]

Descripción:
-------------

![Esquema del problema](http://github.com/descripcion1.jpg)

> **Problema Bodega:**

>La capacidad de la bodega es de 200 $m^3$. En la bodega se pueden colocar dos tipos de artículos, tipo 1 de volumen 10 $m^3$ y tipo 2 de 15 $m^3$. Cada vez se coloca un artículo, puede ser descargarArticulo(1) o descargarArticulo(2). Para crear un paquete el empacador necesita 3 artículos tipo 1 y 4 tipo 2, si no los hay debe esperar.
>![Diagrama de clases](https://github.com/)

#### <i class="icon-pencil"></i> Solución

Para resolver este ejercicio se tuvo en cuenta semáforos mutex, probehen, e incrementan. A continuación se muestra el digrama de clases generado: 

> ![Diagrama de clases generado](https://github.com/Bryan100/Semaforo/blob/master/resources/Diagrama%20de%20Clases.jpg)

Luego se muestra la consola de la apliacion: 

> ![Consola aplicacion](https://github.com/)

  [^semaforo]: [Semáforo](https://es.wikipedia.org/wiki/Sem%C3%A1foro_(inform%C3%A1tica)) Tomado de: 
  https://es.wikipedia.org/wiki/Sem%C3%A1foro_(inform%C3%A1tica)
