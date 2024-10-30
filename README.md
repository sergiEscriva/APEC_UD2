# MOTORSPORT DATABASE
Este proyecto es una base de datos de deportes de motor, en la que se pueden encontrar datos de pilotos, escuderías, 
circuitos, carreras, etc. La base de datos está compuesta por 8 tabla: pilotos, categoria, chassis. equipo, ruedas, entradaPiloto, evento y motor.

| Atributo         | Tipo         | Descripción                                             |
|------------------|--------------|---------------------------------------------------------|
| `id`            | `int`        | Identificador único del piloto                           |
| `nombre`        | `String`     | Nombre del piloto                                       |
| `apellido`      | `String`     | Apellido del piloto                                     |
| `fecha_muerte`  | `LocalDate`  | Fecha de fallecimiento del piloto (si aplica)           |
| `fecha_nacimiento` | `LocalDate`| Fecha de nacimiento del piloto                          |
| `lugar_muerte`  | `String`     | Lugar de fallecimiento del piloto (si aplica)           |
| `nacionalidad`  | `String`     | Nacionalidad del piloto                                 |

| Atributo        | Tipo     | Descripción                                  |
|-----------------|----------|----------------------------------------------|
| `id`            | `int`    | Identificador único de la categoría          |
| `nombre`        | `String` | Nombre de la categoría                       |
| `nombre_corto`  | `String` | Nombre corto de la categoría                 |
| `relevancia`    | `int`    | Nivel de relevancia de la categoría          |

| Atributo        | Tipo      | Descripción                                  | 
|-----------------|-----------|----------------------------------------------|
| `entrada_id`    | `int`     | Identificador de la entrada                  |
| `piloto_id`     | `int`     | Identificador del piloto asociado            |
| `rookie`        | `boolean` | Indica si el piloto es novato               |
| `categoria`     | `int`     | Identificador de la categoría                |

| Atributo         | Tipo     | Descripción                                  |
|------------------|----------|----------------------------------------------|
| `id`             | `int`    | Identificador único del evento               |
| `nombre_equipo`  | `String` | Nombre del equipo asociado                  |
| `chassis_id`     | `int`    | Identificador del chasis                     |
| `motor_id`       | `int`    | Identificador del motor                      |
| `dirigido_por`   | `int`    | Identificador del director del equipo        |
| `ruedas_id`      | `int`    | Identificador de las ruedas                  |
| `numero_piloto`  | `String` | Número del piloto asociado                   |
| `equipo_id`      | `int`    | Identificador del equipo                     |
| `categoria_id`   | `int`    | Identificador de la categoría                |

| Atributo         | Tipo     | Descripción                                  |
|------------------|----------|----------------------------------------------|
| `id`             | `int`    | Identificador único de las ruedas            |
| `nombre`         | `String` | Nombre de las ruedas                         |
| `color_letra`    | `String` | Color de la letra en las ruedas              |
| `color_fondo`    | `String` | Color de fondo de las ruedas                 |

| Atributo           | Tipo         | Descripción                                |
|--------------------|--------------|--------------------------------------------|
| `id`               | `int`        | Identificador único del piloto             |
| `nombre`           | `String`     | Nombre del piloto                          |
| `apellido`         | `String`     | Apellido del piloto                        |
| `fecha_muerte`     | `LocalDate`  | Fecha de fallecimiento (si aplica)         |
| `fecha_nacimiento` | `LocalDate`  | Fecha de nacimiento del piloto             |
| `lugar_muerte`     | `String`     | Lugar de fallecimiento (si aplica)         |
| `nacionalidad`     | `String`     | Nacionalidad del piloto                    |
| `eventoNombre`     | `String`     | Nombre del evento asociado                 |
