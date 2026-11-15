# NBA Fantasy

Práctica 3 de Android hecha con Kotlin y Jetpack Compose.

La aplicación permite apuntar los partidos de varios jugadores
de la NBA y consultar los puntos que han conseguido.

## Qué se puede hacer

- Ver los partidos registrados.
- Buscar por equipo.
- Añadir un partido con el jugador, equipo, posiciones,
  puntos, rival y fecha.
- Seleccionar varios registros y borrarlos.
- Consultar la ficha de un jugador con su foto,
  biografía y media de puntos.

## Carpetas

- model: clase Jugador.
- data: datos iniciales, equipos y biografías.
- navegacion: navegación entre las tres pantallas.
- ui/pantallas: pantallas de la aplicación.
- ui/componentes: tarjetas, fotos y desplegables.

## Cómo ejecutarlo

Abrir el proyecto en Android Studio, esperar a que termine
la sincronización de Gradle y pulsar Run con un emulador
o un móvil conectado.

## A tener en cuenta

Los partidos iniciales son inventados para probar la aplicación.
Los registros se guardan en memoria, por lo que al cerrar
completamente la aplicación se pierden los cambios.
