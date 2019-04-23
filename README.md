# Programacion1
Curso de Programacion 1 UMG 2019
# Practica 6
Contar palabras en un archivo
# Proyecto 1
Inciso 1: ingresar números hasta ingresar Z y mostrar en pantalla cuál es el número que se repite más veces y el que menos se repite

Inciso 2: realizar un juego de adivinar el número entre 0 y 100 y que en cada iteración indique si el número a adivinar es mayor o menor

Inciso 3: Desarrolle un programa que sirve para realizar operaciones aritméticas. Una operación será ingresada por medio del teclado a través de un String, el cual deberá parsear para determinar el contenido de la operación compuesta. Las operaciones disponibles son: suma (más), resta (menos), multiplicación (por), división (dividido), potencia (elevado) y el único signo de agrupación será el paréntesis. la operación a realizar se hará por medio de la palabra que lo representa.

Inciso 4: Escriba un programa para calcular la nota del curso de Programación 1. La nota se distribuye de la siguiente forma: 10% al primer parcial, un 20% al segundo parcial , 20% de tareas y un 50% el examen final. Debe crear una función que reciba por parámetro 4 notas que corresponden a cada ponderación explicada anteriormente, esta función debe devolver un número entero (redondeado) indicando la nota del alumno. Deberá permitir el calculo de la nota de todos los alumnos que el usuario indique por medio de un ciclo, cada vez que se repita el ciclo pedirá el nombre del alumno y cada nota, por ultimo mostrará un mensaje con el nombre del alumno, la nota obtenida y debe indicar si el alumno ganó o perdió el curso (se gana con 61 mínimo)

Inciso 5: Realizar un programa que pida al usuario información de un día/mes/año posterior al 1978 y a continuación le muestre al usuario el día de la semana con que se corresponde esa fecha. Para realizar este cálculo la única información disponible es que el 1 de Enero de 1978 fue domingo. Para realizar el ejercicio tome en cuenta que el día de la semana se puede obtener a partir del número de días transcurridos entre la fecha introducida por el usuario y la fecha de referencia (1 de enero de 1978). Una vez conocido este valor, el día de la semana será calculado por la siguiente fórmula: dia_semana=n_dias_transcurridos % 7
# Proyecto 2
El organismo judicial requiere la implementación de un sistema que le permita administrar las solicitudes de demanda de pensión alimenticia.

La información que se requiere administrar es en primera instancia la creación de la demanda, la cual debe incluir los siguientes datos: Nombre demandante, nombre demandado, dirección demandado, monto de la pensión.

Luego de tener registrada la demanda se podrá asignar el juez que seguirá el cargo colocando únicamente su número de colegiado.

Por último se dictará una sentencia para indicar si el demandante gana o no su denuncia.

La consulta de una demanda deberá mostrar en un archivo PDF utilizando algún formato formal de demandas del OJ la información de la demanda buscada.

Y por último un reporte que mostrará un listado con todas las denuncias, colocando la información básica de cada una de las denuncias y al final una estadística sobre la información de las demandas, la cual debe mostrar el número de demandas y el monto total, este reporte debe ser generado en un archivo PDF (librería iText).

Considerando que siendo una pequeña base de datos, está anuente a almacenar una gran cantidad de registros, por lo que es necesario utilizar estrategias de organización de archivos, así que en este caso deberán implementarlo por medio de archivos secuenciales de texto.

La aplicación deberá tener las opciones principales para el manejo de la información, por lo tanto, el menu de su programa deberá permitir agregar demanda, buscar demanda, asignación de Juez y veredicto final de su base de datos. 
