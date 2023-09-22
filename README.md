# Proyecto Java Pokémon / David Hidalgo

Este proyecto consiste en una pequeña implementación de los combates Pokémon, con cálculo de daño realizado basado en tipo, stab y demás factores, realizada en forma de API REST con Spring Boot y React.js.

## Instalación y uso

Para empezar a usar el programa, primero es necesario iniciar el servidor de Spring.

Una vez iniciado, abriremos el terminal en la carpeta "frontend" y ejecutaremos el comando `npm run dev`.

Hecho esto, podemos abrir en nuestro navegador la dirección [localhost en el puerto 5173](http://localhost:5173/).

(Falta acabar de implementar la introducción de datos para movimientos)
(La seguridad esta hecha un poco cutre para poder probar si funciona porque quitando el @CrossOrigin del controlador no deja hacer nada y no he tenido tiempo de configurarla bien)
(Al final lo he hecho en forma de api rest en lugar de con thymeleaf y templates (se puede ver en alguno de los commits) porque queria probar para ver si me salia, aunque no se como de bien estará implementado)
