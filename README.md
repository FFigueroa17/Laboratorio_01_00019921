# Laboratorios
Repositorio de entregables de laboratorios

TO - DO Laboratorio 04 

1.	Menciona los tipos de intents que existen y un ejemplo de cada uno

Existen dos tipos de intents:
Explicitos e implicitos, un ejemplo de cada uno podriamos verlo dentro de la aplicacion de este laboratorio:
Un ejemplo de intent explicito es cuando navegamos de la primera Activity hacia la segunda Activity donde mostramos la informacion ingresada anteriormente.
Un ejemplo de intent immplicito, es cuando como por ejemplo cuando en el boton COMPARTIR madamos esa informacion para compartirla con otras partes.

2. 	En qué estado de la aplicación se inicializan las variables y se crea la vista

El estado en el que si inicializan las variables y se crea la vista en es el "OnCreate"


TO - DO Laboratorio 05

1.	¿Qué diferencia existe entre navegar dentro de la aplicación utilizando
	Navigation Component o hacer uso de intents? 
	
El navegation component y los intents, son dos formas diferentes de navegar en una aplicacion android, su principal diferencia se encuentra en la 
forma en la que navegation componente proporciona de una manera mas sencilla e intuitiva y sobre todo mas coherente de navegar dentro de la aplicacion, asi mismo,
normalmente los intents se utilizan para iniciar nuevas actividades o abrir una URL, en cambio, en el navegation component se utilizan mas los fragmentos.

2.	Menciona los componentes fundamentales de Navigation Component

Algunos de sus componentes fundamentales son: 
-NavGraph: Representación del flujo que tendrá la aplicación.
-NavHost: Básicamente un contenedor que almacenará los fragmentos o actividades que se mostrarán en la aplicación.
-NavController: Es una clase que permite gestionar la navegación de la aplicación.
-Destinos
-Acciones

3.	Mencione algunas de las ventajas del Navigation Graph

Permite crear la navegación de la aplicación de una forma más intuitiva, clara y sobre todo más coherente. También permite acceder a una representación visual de lo que será 
el flujo de navegación a través del nav graph.


TO - DO Laboratorio 06

1.	¿En qué consiste el patrón de diseño Repository?

Es un patrón de diseño creacional que proporciona una interfaz para crear objetos en una superclase, mientras permite a las subclases alterar el tipo de objetos que se crearán.
En este caso, nos ayudo con el ViewModel ya que necesitábamos pasarle parametros al ViewModel, el cual por defecto no recibe ninguno. 

2.	¿Qué es el ViewModel?

Basicamente es un contenedor que se queda acplado al ciclo de vida de una activity, fragement, etc. Su principal ventaja es que almacena en caché el estado y lo conserva
durante los cambios de configuración. Esto implica que si la vista se destruye, los datos no se pierdan. 


TO - DO Laboratorio 08

1.	¿Cuál es la principal ventaja de utilizar Recycler View?

Ofrece una carga eficiente de elementos, asi como una personalizacion de los mismos, asi mismo, permite agregar animaciones e iteracciones con los elementos que se renderizan.

2.	Menciona los componentes de RecyclerView y la función que tiene cada uno de ellos

- El archivo xml, que sera el modelo de los items que contendra la lista.
- ViewHolder: a que se utiliza para almacenar una referencia a la vista de cada elemento de la lista. 
- ViewAdapter: este se encarga de vincular los datos de una lista o de un conjunto de datos con las vistas que se muestran en pantalla

TO - DO Laboratorio 09

1.	¿Qué es una coroutine en Kotlin y cómo se diferencia de un hilo tradicional?

Las coroutines son un mecanismo de programación que permite escribir código asíncrono de manera
secuencial y estructurada en Kotlin.

2.	¿Cuál es la importancia de la suspensión en las coroutines y cómo se implementa?

Mientras una coroutine está suspendida, el hilo subyacente puede ser utilizado para ejecutar otras tareas, 
evitando bloqueos innecesarios y maximizando la eficiencia de los recursos.
Se implementa utilizando el atributo "suspend" en la funciones.

3.	¿Cuál es el propósito del Dispatcher en las coroutines y cómo se elige uno adecuado para cada tarea?

La función de un Dispatcher es especificar en qué hilo (o hilos) se ejecutará una coroutine.no pueden realizarse en el hilo principal.
Se elegi que Dispatcher utilizar en funcion del contexto en que estamos, si por ejemplo, necesitamos un ejecutar coroutines en el hilo principal de la aplicación, utilizamos
"Dispatchers.main" . Por otra parte el "Dispatchers.IO" para operaciones de entrada o salida de datos intensivas y "Dispatchers.Default" para tareas de computación intensiva.

4.	¿Cuál es el propósito y el uso de la función async en las coroutines?

Basicamente podria considerarse como un constructor utilizado para lanzar coroutines de manera asíncrona,el resultado se obtiene mediante la función await(). Y es útil cuando se
deben ejecutar tareas concurrentes y combinar los resultados.





