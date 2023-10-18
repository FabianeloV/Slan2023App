package com.example.prototiposlan.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
sealed class Schedule(
    val event: String,
    val ubication: String,
    val hour: String,
    val description: String,
    val speaker:String,
    val code:String,
    var showDialog:MutableState<Boolean> = mutableStateOf(false)
) {
    object T2 : Schedule(
        "El Código Internacional de Comercialización de Sucedáneos de Leche Materna (CICSLM), su impacto en las políticas de Lactancia materna y Aplicación del Conjunto de Instrumentos para su Monitoreo",
        "Sala 3 Arquitectura",
        "8:00 a 13:00 Hrs",
        "Objetivos del taller: Este curso-taller permitirá a los participantes adquirir una comprensión del Código (CICSLM) y su impacto en las políticas de lactancia materna; desarrollar habilidades prácticas para evaluar y abordar las violaciones mediante el paquete de instrumentos del NetCode. Además, fomentará la colaboración y el intercambio de experiencias entre los participantes, lo que facilitará la creación de una red de apoyo y promoción de la lactancia materna en diversos entornos y contextos. Público Objetivo del taller: Profesionales de la salud, personal de atención materno-infantil, representantes de gobiernos y organizaciones no gubernamentales, fabricantes de productos relacionados con la alimentación infantil, y madres y padres interesados en proteger los derechos de los bebés y promover la lactancia materna. El Código Internacional de Comercialización de Sucedáneos de Leche Materna es una recomendación crucial promulgada por la OMS, que busca proteger y promover la lactancia materna, asegurando que los sustitutos de la leche materna no se promocionen de manera inapropiada ni interfieran con esta opción de alimentación óptima para los bebés. Sin embargo, la falta de conocimiento y comprensión sobre el Código ha llevado a violaciones frecuentes y prácticas comerciales engañosas. Por tal motivo, es fundamental proporcionar a los participantes el conocimiento y las herramientas necesarias para su comprensión y que sean parte de su vigilancia y cumplimiento.",
        "Dra. Rocio Caicedo. Prof. Rafael Perez-Escamilla ",
        "T2"
    )

    object T3 : Schedule(
        "Métodos cualitativos en investigaciones nutricionales",
        "Sala 4 Hugo Ordóñez",
        "8:15 a 12:15 Hrs",
        "Objetivos del taller: Brindar conocimientos y destrezas que permitan realizar investigaciones cualitativas en nutrición, salud y sistemas alimentarios con un enfoque basado en comportamiento humano (ej., conocimientos, actitudes y prácticas) y sociedad (ej. normas culturales, instituciones). Público Objetivo del taller: estudiantes y profesionales en nutrición, salud y sistemas alimentarios que (i) desean conocer sobre la aplicación de métodos cualitativos en investigación, y también para aquellas personas que (ii) quieren ampliar conocimientos y mejorar capacidades en metodología cualitativa. El taller está dividido en dos partes. Desde un enfoque en la teoría fundamentada (grounded theory), el taller presenta en forma interactiva y con ejercicios, las tres fases de la investigación cualitativa: planificación, trabajo de campo y análisis de los datos. Entre los temas que se discuten están: la identificación y selección de participantes, recolección de datos a través de entrevistas, grupos focales y otros métodos, codificación y análisis de datos y preparación de informes, publicaciones y reportes a la comunidad. El taller incluye un ejercicio reflexivo sobre los roles, la ética y la relación entre investigadores y las personas investigadas. Se ofrecen conceptos, herramientas y actividades participativas para entender y trabajar con una perspectiva psicosocial. Finalmente, se comparten casos de estudio acompañado de ejercicios en grupo."
        , "Dr. William F. Waters. Dr. Carlos Andres Gallegos Riofrío ",
        "T3"
    )

    object T1 : Schedule(
        "La aplicación de investigación participativa en nutrición",
        "Sala 2 Aula Magna Mario Vintimilla ",
        "9:00 a 13:00 Hrs",
        "Objetivos del taller: 1. Fortalecer la capacidad de implementar investigación participativa en nutrición. 2. Promover principios de investigación que produce resultados útiles para las poblaciones que participan de la misma. 3. Implementar ejemplos de la investigación para la promoción y prevención de las enfermedades relacionadas a la nutrición. Este taller utilizará actividades prácticas complementadas con bases teóricas y ejemplos concretos para fortalecer la capacidad de implementar investigación participativa en nutrición. Abordaremos tres fases de investigación participativa: (1) conceptualización y desarrollo de un proyecto; (2) colecta de datos con herramientas participativas; y (3) devolución de resultados y compartir de conocimientos. El taller nace de la necesidad de implementar procesos de investigación que cumplan con varios criterios: son culturalmente apropiados y respetuosos; responden a prioridades y generan resultados útiles para las comunidades participantes; utilizan herramientas aptas para poblaciones con poca educación formal o con barreras de idioma, y que reducen la carga cognitiva y/o carga de tiempo sobre los participantes; implementan métodos que son enriquecedores para las comunidades e individuos que participan. Las herramientas participativas presentadas incluyen: adaptación de “pile sorting” (método de clasificación de imágenes) para usos en nutrición; recordatorio 24 horas visual y colectivo; aplicación en nutrición de “backcasting” (método narrativo para desvelar perspectivas endógenas de cómo se produce un resultado (ej. diabetes)); observación participante; y etnografía enfocada. De estas herramientas, algunas serán demostradas de manera práctica (“participativa”) en el taller, y las otras a través de ejemplos concretos desde experiencias con comunidades rurales en Ecuador y comunidades indígenas en Canadá. Estas se complementan con fundamentos teóricos sobre los objetivos de la investigación participativa, el análisis de datos de las herramientas presentadas, y pautas para apoyar el proceso de diseñar un proyecto participativo (o integrar componentes participativos dentro de proyectos actuales)."
    , "Dra. Ana Deaconu. Dra. Myriam Paredes Chauca ",
        "T1"
    )

    object Taller1 : Schedule(
        "Taller: Conexión con la naturaleza y la salud",
        "Coliseo Julio Abad",
        "9:00 a 11:00 Hrs",
        "",
        "Agencia Organizadora SLAN 2023",
        "Taller"
    )

    object T5: Schedule(
        "Orientaciones sobre lactancia materna, técnicas de extracción, almacenamiento y alimentación del lactante con leche materna extraída",
        "Sala 3 Arquitectura",
        "9:00 a 12:00 Hrs",
        "Institución Organizadora: Pontificia Universidad Católica del Ecuador Objetivos del taller: Sensibilizar a los participantes sobre la importancia de la lactancia materna Fortalecer las competencias de asesoría en lactancia materna para ayudar a las madres a amamantar correctamente. Reforzar las prácticas sobre extracción manual de leche materna usando simuladores de entrenamiento. Reasegurar los conocimientos de los participantes en relación a las técnicas de alimentación del lactante con leche materna extraída. Público Objetivo del taller: Estudiantes y profesionales de la salud que en su práctica diaria estén en contacto con mujeres en periodo de lactancia (Estudiantes y profesionales de nutrición, enfermería, psicología, medicina, obstetricia, dietistas) Este taller brinda información sobre los numerosos beneficios que la lactancia materna ofrece tanto a los niños, a las madres, a la sociedad y al medio ambiente. Se proporcionará información sobre las situaciones que requieren que una mujer extraiga la leche materna, cómo apoyar la producción exitosa de leche durante periodos de ausencia y cómo garantizar una producción efectiva de leche y lactancia materna a largo plazo. Además, el taller tiene como objetivo fortalecer las competencias de los estudiantes o profesionales de la salud sobre técnicas efectivas y seguras para extraer leche materna, abordando situaciones que requieren esta práctica y para ofrecer apoyo sólido a las mujeres en periodo de lactancia. Para la verificar de las competencias se usan instrumentos como los ECOE exámenes clínicos objetivos por competencias que permiten que cada participante evalúe su desempeño ante situaciones prácticas simuladas y donde ponen de manifiesto su razonamiento clínico, habilidades y la comunicación entre la persona que brinda la asesoría y la mujer en periodo de lactancia que recibe la información. Este taller permitirá actualizar los conocimientos con evidencia científica actualizada y a través de los procesos de sensibilización, motivar a los participantes en ser promotores activos de la lactancia materna."
    , "Dra. Betzabé Tello Ponce",
        "T5"
    )

    object T6: Schedule(
        "Estimación de ingesta: Método de Recordatorio, herramientas de análisis y emparejamiento de tablas de composición",
        "Sala 4 Hugo Ordóñez",
        "9:00 a 12:00 Hrs",
        "Materiales y espacios requeridos para la realización del taller: Tablero, infocus, cada participante puede venir con su computadora con instalación de R y RStudio. Número de cupos ofertados: 30 Institución Organizadora: USFQ - ISYN Objetivos del taller: - Entender los métodos de estimación de ingesta nutricional, - Introducción al uso de nuevas soluciones tecnológicas para emparejar tablas de composición y encuestas Público Objetivo del taller: Personas familiarizadas con cuestionarios de ingesta Personas interesadas en el análisis de datos Breve resumen de su propuesta de taller Evaluar la ingesta dietaria es una tarea fundamental en nutrición poblacional y llegar a estimaciones precisas siempre un reto. En fundamental para analizar asociaciones entre la dieta y la salud. Por ellos varios métodos estandarizados existen para obtener estimados de alimentos consumidos y las porciones ingeridas. Dentro de los métodos mencionaremos métodos prospectivos (registro por pesada de alimentos) y retrospectivos. Ahí se encuentran los cuestionarios de frecuencia de consumo (CFC), el recordatorio de 24 horas (R24h) y las historias dietarias. El R24h y los CFC son los principalmente utilizados en la investigación en nutrición. Sin embargo, pese a los esfuerzos que existen en el levantamiento de información, el emparejamiento con información de tablas de composición es seguramente el más pesado en tiempo y sujeto a errores variados. Detallaremos metodologías claras de análisis de información textual y técnicas de emparejamiento de texto para juntar esta información con bases de datos de composición de alimentos."
    , "Sr. Philippe Belmont",
        "T6"
    )

    object T4: Schedule(
        "Estimación de la composición química de recetas utilizando bases de datos de composición de alimentos",
        "Sala 2 Aula Magna Mario Vintimilla",
        "9:00 a 16:00 Hrs",
        "Institución Organizadora: SLAN (Sociedad Latinoamericana de Nutrición) Brasil Foods, FORC, USR, FAPESP, Costa RicaFoods, LATINFOODS Objetivos del taller: Estimar la composición química de preparaciones de consumo usual en la población mediante los métodos de cálculo directo, indirecto y mixto, usando una base de datos de composición de alimentos nacional y aplicando factores (fracción comestible, conversión y retención de nutrientes), siguiendo los parámetros de INFOODS/FAO. Público Objetivo del taller: Estudiantes (nutrición e ingeniería de alimentos con conocimientos previos sobre uso de tablas de composición de alimentos y cálculo de valor nutritivo), profesionales de la salud e investigadores, profesionales de carreras afines con composición de alimentos. El taller tendrá dos secciones, una sección teórica con una duración de dos horas donde se abordarán algunos temas relacionados a la composición de alimentos, cálculo de preparaciones, normativas, formularios, publicaciones, entre otros. Además, una sección práctica con una duración de cuatro horas para realizar el cálculo de diferentes preparaciones empleando los métodos directo, indirecto y mixto."
    , "Dra. Kristy Soraya Coelho",
        "T4"
    )

    object Conf: Schedule(
        "Conferencia inaugural y cóctel de bienvenida",
        "Sala 1 Auditorio Carlos Cueva",
        "18:00 a 21:00 Hrs",
        "Conferencia de apertura y brindis general",
        "Francesco Branca",
        "Conf"
    )

    object Music: Schedule(
        "Música ritmo y Actividad Física",
        "Coliseo y Estadio de la Universidad de Cuenca",
        "7:00 a 7:45 Hrs",
        "",
        "Susana Andrade Tenesaca. Teodoro Contreras Calle ",
        "Musica"
    )
    object S1: Schedule(
        "Understanding and amplifying the role of women’s leadership in food systems transformation",
        "Sala 2 Aula Magna Mario Vintimilla",
        "8:20 a 9:35 Hrs",
        "",
        "Dra. Shu Wen Ng. Dra. Ana Clara Duran. Dra. Wilma Freire Zaldumbide",
        "S1"
    )

    object S2: Schedule(
        "Avances de la región en el cumplimiento de las metas del plan de acción en contra de la desnutrición aguda",
        "Sala 3 de Arquitectura",
        "8:20 a 9:35 Hrs",
        "",
        "Francesco Branca. Sra. Maaike Arts",
        "S2"
    )

    object S3: Schedule(
        "Costo e impacto ambiental de las dietas saludables y sostenibles en América Latina",
        "Sala 4 Hugo Ordóñez",
        "8:20 a 9:35 Hrs",
        "",
        "Sra. Thaís Cristina Marquezine Caldeira. Dra. Mishel Unar",
        "S3"
    )

    object S16: Schedule(
        "Modelos de Sistemas Alimentarios Sostenibles en Alimentación Escolar: oportunidades y desafíos para América Latina y el Caribe (PMA)",
        "Sala 5 Economía",
        "8:20 a 9:35 Hrs",
        "",
        "Dr. Juan Rivera. Dra. Shirley Silva Diogo.",
        "S16"
    )

    object S4: Schedule(
        "Caracterización, percepción y enfrentamiento estructural de los entornos alimentarios",
        "Sala 6 Auditorio Las Monjas",
        "8:20 a 9:35 Hrs",
        "",
        "Dra. Marcela Agustina Araya Bannout. Dra. Lorena Rodríguez-Osiac",
        "S4"
    )

    object S6: Schedule(
        "Redes de alimentos alternativos para la prevención de la diabetes tipo II y la hipertensión arterial",
        "Sala 7 Auditorio Ex- Ciencias Químicas",
        "8:20 a 9:35 Hrs",
        "",
        "Srta. Sara Latorre Tomas. Srta. Bana Salameh",
        "S6"
    )
    object S7: Schedule(
        "Determinantes comerciales de la salud, la alimentación y nutrición de las poblaciones en América Latina.",
        "Sala 8 de audiencias Jurisprudencia",
        "8:20 a 9:35 Hrs",
        "",
        "Dra. Eliana María Pérez Tamayo. Dra. Eliana María Pérez Tamayo",
        "S7"
    )
    object CM1: Schedule(
        "Alimentación perceptiva para el crecimiento y el desarrollo: Políticas para la promoción de una alimentación saludable desde el comienzo de la vida",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "9:45 a 10:15 Hrs",
        "",
        "Prof. Rafael Perez-Escamilla ",
        "CM1"
    )
    object CM2: Schedule(
        "First-food systems and corporate power",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "10:20 a 10:50 Hrs",
        "",
        "Philip Baker",
        "CM2"
    )
    object SP1:Schedule(
        "Sesión de Pósters 1",
        "Patio de la biblioteca",
        "10:50 a 11:30 Hrs",
    "",
        "Mrs. Mariana Bordinhon de Moraes. Dra. Isabel Pereyra González ",
        "SP1"
    )
    object MT1: Schedule(
        "Desafíos de la alimentación durante el primer año de vida",
        "Sala 9 Aula Taller",
        "11:30 a 12:30 Hrs",
        "",
        "Dra. Ascensión Marcos Sánchez. Mgtr. Sandra Nora Blasi ",
        "MT1"
    )
    object S8: Schedule(
        "Los determinantes sociales, ambientes y económicos de la obesidad infantil (UNICEF)",
        "Sala 2 Aula Magna Mario Vintimilla",
        "11:30 a 12:45 Hrs",
        "",
        "Dr. Juan Rivera. Mgtr. Veronica Risso Patron ",
        "S8"
    )
    object S9: Schedule(
        "Una mirada a la respuesta migratoria en América Latina y el Caribe: experiencias, desafíos y oportunidades para mejorar el acceso a sistemas de protección social y salud (PMA)",
        "Sala 3 Arquitectura",
        "11:30 a 12:45 Hrs",
        "",
        "Rolando Wilson. Matthias Sasche",
        "S9"
    )
    object S10: Schedule(
        "Nuevo enfoque en el desarrollo e implementacion de las guías alimentarias basadas en sistemas alimentarios",
        "Sala 4 Hugo Ordóñez",
        "11:30 a 12:45 Hrs",
        "",
        "Dr. Israel Rios-Castillo. Dra. Ana de Lourdes Islas Ramos ",
        "S10"
    )
    object S11: Schedule(
        "La pandemia silenciosa de la obesidad: un enfoque multi e interdisciplinario para su prevención y tratamiento",
        "Sala 5 Economía",
        "11:30 a 12:45 Hrs",
        "",
        "Mgtr. Sandra Maria Gomez Aguirre. Mgtr. Mylene Rodríguez Leyton ",
        "S11"
    )
    object S12: Schedule(
        "Seguridad alimentaria y soberanía alimentaria: aportes de la agroecología",
        "Sala 6 Auditorio Las Monjas",
        "11:30 a 12:45 Hrs",
        "",
        "Mgtr. Susana Anda. Dr. William F. Waters",
        "S12"
    )
    object S23: Schedule(
        "Resultados de la implementación final de la ley de etiquetado y publicidad de los alimentos en Chile",
        "Sala 7 Auditorio Ex- Ciencias Químicas",
        "11:30 a 12:45 Hrs",
        "",
        "Dra. Camila Corvalán Aguilar. Ph.D. Lindsey Smith Taillie",
        "S23"
    )
    object S13: Schedule(
        "Diseño centrado en las personas para el cambio social y de comportamiento; tres casos de éxito para promover la alimentación complementaria de África a Latinoamérica: Nigeria, Zambia y Guatemala",
        "Sala 8 Sala de Audiencias Jurisprudencia",
        "11:30 a 12:45 Hrs",
        "",
        "Srta. Isabel Sandoval. Srta. Jacqueline Oliveira",
        "S13"
    )
    object C16:Schedule(
        "Sobrepeso y obesidad en América Latina y El Caribe: Reporte Regional (UNICEF)",
        "Sala 1 Teatro Carlos Cueva Tamariz ",
        "14:05 a 14:35 Hrs",
        "",
        "Sra. Maaike Arts ",
        "C16"
    )
    object CM3: Schedule(
        "Título pendiente | Popkin Barry",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "14:40 a 13:10 Hrs",
        "",
        "Prof. Barry Popkin",
        "CM3"
    )
    object PCO1: Schedule(
        "Presentación de Comunicaciones Orales 1 - Entornos alimentarios",
        "Sala 2 Aula Magna Mario Vintimilla",
        "15:20 a 16:15 Hrs",
        "",
        "Mgtr. Sonia Ana Naumann. Dra. Lorena Rodríguez-Osiac",
        "PCO1"
    )
    object PCO2: Schedule(
        "Presentación de Comunicaciones Orales 2 - Consumo de alimentos ultraprocesados",
        "Sala 3 Arquitectura",
        "15:20 a 16:15 Hrs",
        "",
        "Mrs. Sabrina Rimouche. Ph.D. Renata Levy ",
        "PCO2"
    )
    object PCO3: Schedule(
        "Presentación de Comunicaciones Orales 3 - Monitoreo nutricional",
        "Sala 4 Hugo Ordóñez",
        "15:20 a 16:15 Hrs",
        "",
        "Mgtr. Violeta Magdalena Rojas Huayta ",
        "PCO3"
    )
    object PCO4: Schedule(
        "Presentación de Comunicaciones Orales 4 - Avances en las guías nutriconales",
        "Sala 5 Aula magna Economía",
        "15:20 a 16:15 Hrs",
        "",
        "Prof. Cecilia Barrios Espinosa.",
        "PCO4"
    )
    object PCO5: Schedule(
        "Presentación de Comunicaciones Orales 5 - Avances en la investigación en la alimentación",
        "Sala 6 Auditorio Las Monjas",
        "15:20 a 16:15 Hrs",
        "",
        "Dr. Jorge Pérez Galarza",
        "PCO5"
    )
    object PCO6: Schedule(
        "Presentación de Comunicaciones Orales 6 - Alimentos e innovación",
        "Sala 7 Auditorio Ex-Ciencias Químicas",
        "15:20 a 16:15 Hrs",
        "",
        "Lic. Verena Araújo Severo",
        "PCO6"
    )
    object PCO7: Schedule(
        "Presentación de Comunicaciones Orales 7 - Entornos alimentarios III",
        "Sala 8 Sala de Audiencias Jurisprudencia",
        "15:20 a 16:15 Hrs",
        "",
        "Sra. Marcela Mello Soares Rodrigues ",
        "PCO7"
    )
    object PCO8: Schedule(
        "Presentación de Comunicaciones Orales 8 - Mujer y alimentación",
        "Sala 9 Aula Taller",
        "15:20 a 16:15 Hrs",
        "",
        "Prof. Sandra Lucía Restrepo Mesa",
        "PCO8"
    )

    object SP2:Schedule(
        "Sesión de Pósters 2",
        "Patio de la biblioteca",
        "16:15 a 16:30 Hrs",
        "",
        "Dr. Fabio da Silva Gomes",
        "SP2"
    )
    object MT2: Schedule(
        "Problemas contemporáneos en alimentación, nutrición y sustentabilidad. Relevancia para la formación de recursos humanos en nutrición, alimentación y áreas relacionadas",
        "Sala 9 Aula Taller",
        "16:30 a 17:30 Hrs",
        "",
        "Dra. Patricia Jaime",
        "MT2"
    )
    object S14: Schedule(
        "Plan de aceleración para la prevención y control de obesidad OMS-WOF en Latinoamérica",
        "Sala 2 Aula Magna Mario Vintimilla",
        "16:30 a 17:45 Hrs",
        "",
        "Dr. Fabio da Silva Gomes",
        "S14"
    )
    object S15: Schedule(
        "Comunicación para el cambio de comportamiento social orientada a generar prácticas de vida saludables desde la niñez (UNICEF)",
        "Sala 3 Arquitectura",
        "16:30 a 17:45 Hrs",
        "",
        "Dr. Rowena Merritt",
        "S15"
    )
    object S71: Schedule(
        "Red de Alimentación Escolar Sostenible Avances y perspectivas en ALC",
        "Sala 4 Hugo Ordóñez",
        "16:30 a 17:45 Hrs",
        "",
        "Agencia Organizadora SLAN 2023",
        "S71"
    )
    object S66: Schedule(
        "Alimentación del lactante y el niño pequeño en contextos de emergencias en LAC (UNICEF)",
        "Sala 5 Aula Magna Economía",
        "16:30 a 17:45 Hrs",
        "",
        "Sra. Maaike Arts ",
        "S66"
    )
    object S17: Schedule(
        "El estado de nutrición en niños y adolescentes mexicanos: su evaluación desde diferentes perspectivas y algunas estrategias para la acción",
        "Sala 6 Auditorio Las Monjas",
        "16:30 a 17:45 Hrs",
        "",
        "Dra. Teresa Shamah Levy",
        "S17"
    )
    object S18: Schedule(
        "Investigación social en el campo de la nutrición en Guatemala: perspectivas desde la experiencia nacional y aplicada",
        "Sala 7 Auditorio Ex-Ciencias Químicas",
        "16:30 a 17:45 Hrs",
        "",
        "Mgtr. Rosario García-Meza",
        "S18"
    )
    object S19: Schedule(
        "Desafíos sobre la ingesta de micronutrientes en América Latina en la era de la crisis alimentaria e industrialización de la dieta",
        "Sala 8 Sala de Audiencias Jurisprudencia",
        "16:30 a 17:45 Hrs",
        "",
        "Dra. Maria Fernanda Mujica Coopman",
        "S19"
    )
    object E1: Schedule(
        "Lanzamiento de la Alianza Mundial para la Alimentación Saludable en Niñas y Niños: Capítulo América Latina y el Caribe",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "18:00 a 19:30 Hrs",
        "",
        "Dr. Juan Rivera. Mtro. Mauro Brero",
        "E1"
    )

    object YOGA: Schedule(
        "Yoga y atención plena",
        "Coliseo y Estadio de la Universidad de Cuenca",
        "7:00 a 7:45 Hrs",
        "",
        "Susana Andrade Tenesaca",
        "YOGA"
    )

    object MT8: Schedule(
        "Rutas de impacto de Programas de Protección Social hacia la Nutrición en América Latina y el Caribe: el caso del Programa de Alimentación Escolar de Guatemala (PMA)",
        "Sala 9 Aula Taller",
        "8:20 a 9:20 Hrs",
        "",
        "Carla Mejia. Nicholas Nisbett",
        "MT8"
    )
    object S20: Schedule(
        "Gene-nutrient interactions- implications for nutrition interventions",
        "Sala 2 Aula Magna Mario Vintimilla",
        "8:20 a 9:35 Hrs",
        "",
        "Dra. Usha Ramakrishnan",
        "S20"
    )
    object S21: Schedule(
        "El monitoreo y el combate a la interferencia de la industria en las políticas públicas de alimentación y nutrición en latinoamérica y el caribe",
        "Sala 3 Arquitectura",
        "8:20 a 9:35 Hrs",
        "",
        "Beatriz Marcet Champagne. Dra. Laís Amaral Mais",
        "S21"
    )
    object S22: Schedule(
        "Habilidades culinarias domésticas para promover una nutrición adecuada y saludable",
        "Sala 4 Hugo Ordóñez",
        "8:20 a 9:35 Hrs",
        "",
        "Semiramis Martins Álvares",
        "S22"
    )
    object S68: Schedule(
        "La cohorte NutriNet Brasil: creación y acompañamiento por la Internet, instrumentos de coleta de datos sobre alimentación y estado de salud y resultados de asociaciones prospectivas dieta-riesgo de enfermedades crónicas",
        "Sala 5 Aula Magna Economía",
        "8:20 a 9:35 Hrs",
        "",
        "Ph.D. Renata Levy",
        "S68"
    )
    object S24: Schedule(
        "Calidad de la atención nutricional materno infantil en el primer nivel de atención: implicaciones metodológicas y resultados en México",
        "Sala 6 Auditorio Las Monjas",
        "8:20 a 9:35 Hrs",
        "",
        "Dra. Elizabeth Hoyos Loya",
        "S24"
    )
    object S25: Schedule(
        "Desigualdades en salud y malnutrición infantil en poblaciones indígenas de Latinoamérica",
        "Sala 7 Auditorio Ex-Ciencias Químicas\n",
        "8:20 a 9:35 Hrs",
        "",
        "Dra. Giovanna Laura Maria Gatica Dominguez ",
        "S25"
    )
    object S26: Schedule(
        "La alimentación tradicional: una perspectiva vigente en la actuación del nutricionista dietista",
        "Sala 8 Sala de Audiencias Jurisprudencia",
        "8:20 a 9:35 Hrs",
        "",
        "Dra. Luz Marina Arboleda-Montoya",
        "S26"
    )
    object CM5: Schedule(
        "Hacia una imposición a productos ultraprocesados: ¿Por qué es una buena idea?",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "9:45 a 10:15 Hrs",
        "",
        "Dr. Guillermo Paraje",
        "CM5"
    )
    object CM6: Schedule(
        "Políticas de prevención y control de la obesidad y promoción de alimentación saludable en Latinoamérica",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "10:20 a 10:50 Hrs",
        "",
        "Dr. Simón Barquera",
        "CM6"
    )
    object SP3:Schedule(
        "Sesión de Pósters 3",
        "Patio de la Biblioteca",
        "10:50 a 11:30 Hrs",
        "",
        "Dr. Henry Guija Guerra",
        "SP3"
    )
    object MT3: Schedule(
        "Éxitos y desafíos en el desarrollo y la implementación de políticas de alimentación saludable en entornos escolares en Latinoamérica",
        "Sala 9 Aula Taller",
        "11:30 a 12:30 Hrs",
        "",
        "Prof. Mariana Espinosa Estrada",
        "MT3"
    )

    object S28: Schedule(
        "Dibujando una ruta para combatir la malnutrición: marketing de alimentos y bebidas no saludables y medidas para mitigar sus efectos (UNICEF)",
        "Sala 3 Arquitectura",
        "11:30 a 12:45 Hrs",
        "",
        "Dr. Simón Barquera",
        "S28"
    )
    object S29: Schedule(
        "Un fitoprostano del alga Gracilaria longissima aumenta la activación plaquetaria, la adhesión plaquetaria a leucocitos y la migración celular endotelial mediante una unión potencial al receptor prostaglandina EP3",
        "Sala 4 Hugo Ordóñez",
        "11:30 a 12:45 Hrs",
        "",
        "Dr. Angel Gil Izquierdo",
        "S29"
    )
    object S30: Schedule(
        "Nuevos Horizontes de la Educación Alimentaria Nutricional (EAN)",
        "Sala 5 Aula Magna Economía",
        "11:30 a 12:45 Hrs",
        "",
        "Dra. Nelly Bustos Zapata",
        "S30"
    )
    object S65: Schedule(
        "Proceso de actualización de las nuevas Guías Alimentarias para la población mexicana",
        "Sala 6 Auditorio Las Monjas",
        "11:30 a 12:45 Hrs",
        "",
        "Dra. Anabelle Bonvecchio Arenas",
        "S65"
    )
    object S31: Schedule(
        "Determinantes de la calidad de la dieta y contribución de la Ingesta de proteínas, grasas y ácidos grasos esenciales y colina. Resultados del Estudio ELANS",
        "Sala 7 Auditorio Ex-Ciencias Químicas",
        "11:30 a 12:45 Hrs",
        "",
        "Prof. Martha Cecilia Yepez Garcia",
        "S31"
    )
    object S32: Schedule(
        "Aportes de la red LATINFOODS al conocimiento de alimentos nativos de Latinoamerica",
        "Sala 8 Sala de Audiencias Jurisprudencia",
        "11:30 a 12:45 Hrs",
        "",
        "Dra. Cindy Hidalgo Víquez",
        "S32"
    )
    object S56: Schedule(
        "Determinantes comerciales de la salud: impacto en las enfermedades crónicas y soluciones en la práctica",
        "Sala 5 Aula Magna Economía",
        "11:30 a 12:45 Hrs",
        "",
        "Mtra. Fiorella Espinosa ",
        "S56"
    )
    object CM7: Schedule(
        "Reporting nutrition research: where are we and what’s next?",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "14:05 a 14:35 Hrs",
        "",
        "Prof. Carl Lachat",
        "CM7"
    )
    object CM8: Schedule(
        "Reformas de los sistemas alimentares en el siglo XXI: el poder de las políticas públicas",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "14:40 a 15:10 Hrs",
        "",
        "Dr. Jean-claude Moubarac ",
        "CM8"
    )
    object PCO9: Schedule(
        "Presentación de Comunicaciones Orales 9 - Medioambiete y alimentación",
        "Sala 2 Aula Magna Mario Vintimilla",
        "15:20 a 16:15 Hrs",
        "",
        "Mgtr. Paola Bernardita Cáceres Rodriguez ",
        "PCO9"
    )
    object PCO10: Schedule(
        "Presentación de Comunicaciones Orales 10 - Etiquetado nutricional",
        "Sala 3 Arquitectura",
        "15:20 a 16:15 Hrs",
        "",
        "Mgtr. Juan Jácome Navarrete",
        "PCO10"
    )
    object PCO11: Schedule(
        "Presentación de Comunicaciones Orales 11 - Regulaciones alimenticias",
        "Sala 4 Hugo Ordóñez",
        "15:20 a 16:15 Hrs",
        "",
        "Dra. María Luisa Garmendia Miguel ",
        "PCO11"
    )
    object PCO12: Schedule(
        "Presentación de Comunicaciones Orales 12 - Entornos alimentarios II",
        "Sala 5 Aula Magna Economía",
        "15:20 a 16:15 Hrs",
        "",
        "Ph.D. Alexandra Pava-Cárdenas",
        "PCO12"
    )
    object PCO13: Schedule(
        "Presentación de Comunicaciones Orales 13 - Bioquímica y alimentación",
        "Sala 6 Auditorio Las Monjas",
        "15:20 a 16:15 Hrs",
        "",
        "Mgtr. Dora Inés Mazariegos Cordero",
        "PCO13"
    )
    object PCO14: Schedule(
        "Presentación de Comunicaciones Orales 14 - Factores influyentes en la compra y consumo de alimentos",
        "Sala 7 Auditorio Ex-Ciencias Químicas",
        "15:20 a 16:15 Hrs",
        "",
        "Sr. Kamila Gabe",
        "PCO14"
    )
    object PCO15: Schedule(
        "Presentación de Comunicaciones Orales 15 - Alimentación e indicadores de salud",
        "Sala 8 Sala de Audiencias Jurisprudencia",
        "15:20 a 16:15 Hrs",
        "",
        "Dra. Ikram Benazizi Dahbi",
        "PCO15"
    )
    object PCO16: Schedule(
        "Presentación de Comunicaciones Orales 16 - Alimentos e innovación II",
        "Sala 9 Aula Taller",
        "15:20 a 16:15 Hrs",
        "",
        "Mgtr. Luis Santiago Guerra Piedra",
        "PCO16"
    )
    object SP4:Schedule(
        "Sesión de Pósters 4\n",
        "Patio de la Biblioteca",
        "16:15 a 16:30 Hrs",
        "",
        "Dr. Israel Rios-Castillo",
        "SP4"
    )
    object MT4: Schedule(
        "Anemia e implicaciones de nueva evidencia para los programas públicos",
        "Sala 9 Aula Taller",
        "16:30 a 17:30 Hrs",
        "",
        "Dr. Lynnette Neufeld",
        "MT4"
    )
    object S33: Schedule(
        "Interactions between industry and nutrition professionals: what do we know and what to do about it?",
        "Sala 2 Aula Magna Mario Vintimilla",
        "16:30 a 17:30 Hrs",
        "",
        "Srta. Virginie Hamel",
        "S33"
    )
    object S70: Schedule(
        "Ácidos grasos trans",
        "Sala 3 Arquitectura",
        "16:30 a 17:45 Hrs",
        "",
        "Dr. Fabio da Silva Gomes",
        "S70"
    )
    object S35: Schedule(
        "Recomendaciones de política pública para combatir la mala nutrición materno infantil desde una perspectiva de equidad, sostenibilidad y curso de vida: análisis y propuestas desde el Observatorio Materno Infantil.",
        "Sala 4 Hugo Ordóñez",
        "16:30 a 17:45 Hrs",
        "",
        "Dr. Eric Alejandro Monterrubio Flores",
        "S35"
    )
    object S36: Schedule(
        "Implementación y efectividad del Etiquetado frontal de advertencia de los alimentos en América Latina",
        "Sala 5 Aula Magna Economía",
        "16:30 a 17:45 Hrs",
        "",
        "Mercedes Mora Plazas",
        "S36"
    )
    object S37: Schedule(
        "Promoviendo una alimentación saludable y sostenible: evidencia emergente desde la perspectiva ambiental, funcional y metabólica",
        "Sala 6 Auditorio Las Monjas",
        "16:30 a 17:45 Hrs",
        "",
        "Dra. Fatima Ezzahra Housni",
        "S37"
    )
    object S38: Schedule(
        "Seguridad hídrica y derecho humano a la alimentación",
        "Sala 7 Auditorio Ex-Ciencias Químicas",
        "16:30 a 17:45 Hrs",
        "",
        "Dr. Pablo Gaitán Rossi",
        "S38"
    )
    object S69: Schedule(
        "Por generaciones saludables: Apoyo técnico basado en evidencia de la OPS/OMS al estado ecuatoriano en su lucha contra la Desnutrición Crónica Infantil",
        "Sala 8 Sala de Audiencias Jurisprudencia",
        "16:30 a 17:45 Hrs",
        "",
        "Dr. Adrián Alberto Díaz",
        "S69"
    )
    object E2: Schedule(
        "Acciones para prevenir la influencia de intereses comerciales en la educación, investigación y políticas de salud del Comité de la Sociedad Latinoamericana de Nutrición",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "18:00 a 19:15 Hrs",
        "",
        "Dr. Simón Barquera",
        "E2"
    )

    object AFF: Schedule(
        "Actividad Física Funcional",
        "Coliseo y Estadio de la Universidad de Cuenca",
        "7:00 a 7:45 Hrs",
        "",
        "Susana Andrade Tenesaca ",
        "AFF"
    )

    object MT5: Schedule(
        "Guías Alimentarias basadas en el procesamiento de alimentos - desarrollo, implementación y evaluación",
        "Sala 9 Aula Taller",
        "8:20 a 9:20 Hrs",
        "",
        "Dra. Wilma Freire Zaldumbide",
        "MT5"
    )
    object S39: Schedule(
        "La investigación en la educación física y deporte vinculada con la alimentación sana en el contexto Latinoamericano",
        "Sala 2 Aula Magna Mario Vintimilla",
        "8:20 a 9:35 Hrs",
        "",
        "Prof. Greet Cardon",
        "S39"
    )
    object S40: Schedule(
        "Políticas para reducir el costo de alimentos nutritivos y mejorar la asequibilidad a una dieta saludable, con enfoque de sistemas agroalimentarios",
        "Sala 3 Arquitectura",
        "8:20 a 9:35 Hrs",
        "",
        "Sra. María Daniela Godoy Gabler",
        "S40"
    )
    object S41: Schedule(
        "Avances y desafíos en la implementación del etiquetado frontal de advertencia de los alimentos en Latinoamérica",
        "Sala 4 Hugo Ordóñez",
        "8:20 a 9:35 Hrs",
        "",
        "Dr. Simón Barquera",
        "S41"
    )
    object S43: Schedule(
        "Prácticas sub-óptimas de alimentación complementaria y mala nutrición en América Latina: un llamado urgente para la acción",
        "Sala 6 Auditorio Las Monjas",
        "8:20 a 9:35 Hrs",
        "",
        "Dra. Maria Reyna Liria Domínguez",
        "S43"
    )
    object S44: Schedule(
        "Los lipofenoles de hidroxitirosol de aceites de oliva son bioaccesibles mediante digestión gastrointestinal in vitro simulada: Desentrañando el papel de las enzimas digestivas en su estabilidad",
        "Sala 7 Auditorio Ex-Ciencias Químicas",
        "8:20 a 9:35 Hrs",
        "",
        "Dr. Angel Gil Izquierdo",
        "S44"
    )
    object S45: Schedule(
        "Desafios de las guias alimentarias para una alimentación saludable, sostenible y con pertinencia cultural",
        "Sala 8 Sala de Audiencias Jurisprudencia",
        "8:20 a 9:35 Hrs",
        "",
        "Dra. Carmen Gloria Gonzalez",
        "S45"
    )
    object CM10: Schedule(
        "Alimentos ultraprocesados y salud humana: la tesis y las evidencias",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "9:50 a 10:20 Hrs",
        "",
        "Prof. Carlos Monteiro",
        "CM10"
    )
    object CM11: Schedule(
        "Shaping food environments through public regulations – the WHO recommendations",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "10:20 a 10:50 Hrs",
        "",
        "Francesco Branca",
        "CM11"
    )
    object SP5:Schedule(
        "Sesión de Pósters 5",
        "Patio de la Biblioteca",
        "10:50 a 11:30 Hrs",
        "",
        "Dra. Vidalma Del Rosario Bezares Sarmiento",
        "SP5"
    )
    object MTC10: Schedule(
        "Estrategias nutricionales para la prevención de la obesidad infantil",
        "Sala 8 Sala de Audiencias Jurisprudencia",
        "11:30 a 12:00 Hrs",
        "",
        "Prof. J Alfredo Martínez",
        "MTC10"
    )
    object S46: Schedule(
        " Strategies for improving health in vulnerable population through community-based health screening and interventions for combating malnutrition in children",
        "Sala 2 Aula Magna Mario Vintimilla",
        "11:30 a 12:45 Hrs",
        "",
        "Dr. Fernando Sempértegui Ontaneda",
        "S46"
    )
    object S47: Schedule(
        "Abordajes metodológicos y desafíos en el logro de guías alimentarias saludables y sostenibles consolidadas: experiencia para su adaptación en infantes, niños pequeños y mujeres embarazadas y lactantes",
        "Sala 3 Arquitectura",
        "11:30 a 12:45 Hrs",
        "",
        "Delhi Anahi Trejo",
        "S47"
    )
    object S48: Schedule(
        "Incai: proyecto integral multidisciplinario experiencia y recomendaciones para el diseño y la aplicación de proyectos en entornos escolares",
        "Sala 4 Hugo Ordóñez",
        "11:30 a 12:45 Hrs",
        "",
        "Prof. María Del Carmen Morales Ruán ",
        "S48"
    )
    object S49: Schedule(
        "The NOVA-UPF screener - a short dietary assessment instrument capturing ultraprocessed food consumption and its validation in multiple countries",
        "Sala 5 Aula Magna Economía",
        "11:30 a 12:45 Hrs",
        "",
        "Prof. Carlos Monteiro",
        "S49"
    )
    object S50: Schedule(
        "Política de alimentación escolar saludable y sostenible en Latinoamérica: estrategias para la incidencia desde la sociedad civil basada en evidencia",
        "Sala 6 Auditorio Las Monjas",
        "11:30 a 12:45 Hrs",
        "",
        "Leo Nederveen",
        "S50"
    )
    object S51: Schedule(
        "Dimensiones de la seguridad alimentaria en el nuevo escenario global. Una mirada sobre la evolución del consumo alimentario mundial y en Argentina en las últimas seis décadas",
        "Sala 7 Auditorio Ex-Ciencias Químicas",
        "11:30 a 12:45 Hrs",
        "",
        "Prof. Beatriz Andrea Graciano",
        "S51"
    )
    object CM12: Schedule(
        "Physical activity: the key to healthy aging",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "14:10 a 14:40 Hrs",
        "",
        "Prof. Greet Cardon",
        "CM12"
    )
    object CM13: Schedule(
        "Cuidado integral de adultos mayores en la comunidad",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "14:40 a 15:10 Hrs",
        "",
        "Dra. Maria Jose Mendieta Jara",
        "CM13"
    )
    object PCO17: Schedule(
        "Presentación de Comunicaciones Orales 17 - Cultura y alimentación",
        "Sala 2 Aula Magna Mario Vintimilla",
        "15:20 a 16:15 Hrs",
        "",
        "Mgtr. Paola Bernardita Cáceres Rodriguez",
        "PCO17"
    )
    object PCO18: Schedule(
        "Presentación de Comunicaciones Orales 18 - Etiquetado de alimentos y patrones de ingesta no saludables.",
        "Sala 3 Arquitectura",
        "15:20 a 16:15 Hrs",
        "",
        "Ph.D. Susana Andrade Tenesaca",
        "PCO18"
    )
    object PCO19: Schedule(
        "Presentación de Comunicaciones Orales 19 - Consumo de alimentos ultraprocesados II",
        "Sala 4 Hugo Ordóñez",
        "15:20 a 16:15 Hrs",
        "",
        "Dra. Isabel Pereyra González",
        "PCO19"
    )
    object PCO20: Schedule(
        "Presentación de Comunicaciones Orales 20 - Alimentación en lactantes, niños y adolescentes",
        "Sala 5 Aula Magna Economía",
        "15:20 a 16:15 Hrs",
        "",
        "Mgtr. Sandra Nora Blasi ",
        "PCO20"
    )
    object PCO21: Schedule(
        "Presentación de Comunicaciones Orales 21 - TPatrones alimentarios",
        "Sala 6 Auditorio Las Monjas",
        "15:20 a 16:15 Hrs",
        "",
        "Mgtr. Maria Del Pilar López Santisteban",
        "PCO21"
    )
    object PCO22: Schedule(
        "Presentación de Comunicaciones Orales 22 - Estrategias para selección y compra de alimentos",
        "Sala 7 Auditorio Ex-Ciencias Químicas",
        "15:20 a 16:15 Hrs",
        "",
        "Mrs. Alícia Tavares da Silva Gomes",
        "PCO22"
    )
    object PCO23: Schedule(
        "Presentación de Comunicaciones Orales 23 - Adulto mayor y alimentación",
        "Sala 8 Sala de Audiencias Jurisprudencia",
        "15:20 a 16:15 Hrs",
        "",
        "Dra. Maria Daniela Abraham",
        "PCO23"
    )
    object PCO24: Schedule(
        "Presentación de Comunicaciones Orales 24 - Disponibilidad y costo de los alimentos",
        "Sala 9 Aula Taller",
        "15:20 a 16:15 Hrs",
        "",
        "Sra. MARIA DEL PILAR ZEA LEÓN",
        "PCO24"
    )
    object SP6:Schedule(
        "Sesión de Pósters 6",
        "Patio de la Biblioteca",
        "16:15 a 16:30 Hrs",
        "",
        "Mgtr. Juana Margarita Flores Luna ",
        "SP6"
    )
    object MT6: Schedule(
        "De la Obesidad a la Diabetes Tipo 2. (Diabesidad)",
        "Sala 9 Aula Taller",
        "16:30 a 17:30 Hrs",
        "",
        "Dr. Miguel Pasquel",
        "MT6"
    )
    object S53: Schedule(
        "Obesity prevention across borders: the promise of US-Latin American research",
        "Sala 3 Auditorio de Facultad de Arquitectura",
        "16:30 a 17:45 Hrs",
        "",
        "Dra. Carolina Batis",
        "S53"
    )
    object S59: Schedule(
        "Para los 1000 primeros días: mamar, comer, jugar y amar (UNICEF)",
        "Sala 2 Aula Magna Mario Vintimilla",
        "16:30 a 17:45 Hrs",
        "",
        "Dra. Anabelle Bonvecchio Arenas",
        "S59"
    )
    object S55: Schedule(
        "Aciertos y retos en la regulación de la mercadotecnia de alimentos y bebidas dirigida a las niñas, niños y adolescentes en la región de América Latina y Caribe",
        "Sala 4 Hugo Ordóñez",
        "16:30 a 17:45 Hrs",
        "",
        "Dra. Florence Lise Theodore",
        "S55"
    )

    object S57: Schedule(
        "Fondo conjunto de cooperación Chile-México: marcos para la acción en intervenciones de ambientes alimentarios en escuelas",
        "Sala 6 Auditorio Las Monjas",
        "16:30 a 17:45 Hrs",
        "",
        "Dra. Nelly Bustos Zapata",
        "S57"
    )
    object S58: Schedule(
        "Agroecología: motor para la transformación del sistema alimentario",
        "Sala 7 Auditorio Ex-Ciencias Químicas",
        "16:30 a 17:45 Hrs",
        "",
        "Dra. Lorena Patricia Mancilla López",
        "S58"
    )
    object S54: Schedule(
        "Experiencias de implementación de programas e intervenciones escolares para la promoción de estilos de vida saludable en Chile, Guatemala y México",
        "Sala 8 Sala de Audiencias Jurisprudencia",
        "16:30 a 17:45 Hrs",
        "",
        "Dr. Edgar Denova Gutiérrez ",
        "S54"
    )
    object Asamblea:Schedule(
        "Asamblea",
        "Sala 2 Aula Magna Mario Vintimilla",
        "18:00 a 19:00 Hrs",
        "",
        "Agencia Organizadora SLAN 2023",
        "Asamblea"
    )
    object MT7: Schedule(
        "Micronutrientes en América Latina: Escenario actual y relevancia",
        "Sala 9 Aula Taller",
        "8:20 a 9:20 Hrs",
        "",
        "Dra. Georgina Gómez Salas ",
        "MT7"
    )
    object S60:Schedule(
        "Why sustainability influences clinical practice and the future of nutrition and health",
        "Sala 2 Aula Magna Mario Vintimilla",
        "8:20 a 9:35 Hrs",
        "",
        "Sra. TATIANA TUCUNDUVA PHILIPPI CORTESE",
        "S60"
    )
    object S61:Schedule(
        "Estrategias eficaces para financiar las políticas para reducir la malnutrición: instrumentos fiscales e incremento de la eficiencia en el uso de los recursos (UNICEF)\n",
        "Sala 3 Auditorio de Facultad de Arquitectura",
        "8:20 a 9:35 Hrs",
        "",
        "Dra. Mishel Unar Morelos",
        "S61"
    )
    object S42:Schedule(
        "Consumo, fuentes e impacto en las políticas nacionales y regionales de reducción de sodio en las américas: necesidad de evaluación de intervenciones",
        "Sala 4 Hugo Ordoñez - Facultad de Jurisprudencia",
        "8:20 a 9:35 Hrs",
        "",
        "Leo Nederveen",
        "S42"
    )
    object S5:Schedule(
        "Protección Social Sensible al VIH: modelo de intervención en la República Dominicana (PMA)",
        "Sala 5 Claudio Cordero - Facultad de Economía ",
        "8:20 a 9:35 Hrs",
        "",
        "Maria Altagracia Fulcar",
        "S5"
    )
    object S63:Schedule(
        "Implementación de las guías alimentarias en América Latina",
        "Sala 6 Las Monjas - Facultad de Economía",
        "8:20 a 9:35 Hrs",
        "",
        "Dra. Kelly Alves ",
        "S63"
    )
    object S67:Schedule(
        "Nutrición en el adulto mayor: rol de la nutrición en la patología geriátrica",
        "Sala 7 Auditorio Ex - Ciencias Químicas",
        "8:20 a 9:35 Hrs",
        "",
        "Dra. Maria Jose Mendieta Jara ",
        "S67"
    )
    object S62:Schedule(
        "Territorio amazónico ecuatoriano en el espectro de la transición nutricional",
        "Sala 8 Sala de Audiencias - Facultad de Jurisprudencia",
        "8:20 a 9:35 Hrs",
        "",
        "Dr. José Andrés Ocaña Navas",
        "S62"
    )
    object CM4:Schedule(
        "Panorama regional de la reducción de sodio y herramientas de política para la implementación de las metas regionales actualizadas de la OPS para la reducción de sodio\n",
        "Sala 1 Teatro Carlos Cueva Tamariz ",
        "9:45 a 10:15 Hrs",
        "",
        "Leo Nederveen",
        "CM4"
    )
    object CM15:Schedule(
        "Dietas saludables: Avances en definiciones y datos para informar acciones efectivas",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "10:20 a 10:50 Hrs",
        "",
        "Dr. Lynnette Neufeld",
        "CM15"
    )
    object MTC1:Schedule(
        "Nutrición y Bioética",
        "Sala 4 Hugo Ordoñez - Facultad de Jurisprudencia",
        "11:30 a 12:00 Hrs",
        "",
        "Dr. Emilio José Ibeas",
        "MTC1"
    )
    object MTC2:Schedule(
        "Cáncer en Latinoamérica: De la prevalencia al diagnóstico y tratamiento nutricional",
        "Sala 5 Claudio Cordero - Facultad de Economía",
        "11:30 a 12:00 Hrs",
        "",
        "Dra. Dolores Rodriguez Veintimilla",
        "MTC2"
    )
    object MTC3:Schedule(
        "Desafíos para el consumo de ácidos grasos Omega 3, edulcorantes, y algas y derivados en un sistema alimentario cambiante",
        "Sala 6 Las Monjas - Facultad de Economía",
        "11:30 a 12:00 Hrs",
        "",
        "Prof. Miguel Ángel Rincón Cervera",
        "MTC3"
    )
    object MTC4:Schedule(
        "Experiencias, cultura, hábitos saludables y longevidad en Latinoamérica",
        "Sala 7 Auditorio Ex - Ciencias Químicas",
        "11:30 a 12:00 Hrs",
        "",
        "Dra. María Elena Acosta Enríquez",
        "MTC4"
    )
    object MTC5:Schedule(
        "El rol de las universidades y centros de investigación en la prevención y atención a la malnutrición",
        "Sala 8 Sala de Audiencias - Facultad de Jurisprudencia",
        "11:30 a 12:00 Hrs",
        "",
        "Dra. Adriana Hernández Santana",
        "MTC5"
    )
    object MTC6:Schedule(
        "Transitar hacia sistemas alimentarios sostenibles: formación, acción y proyecciones para el profesional de la nutrición",
        "Sala 4 Hugo Ordoñez - Facultad de Jurisprudencia",
        "12:00 a 12:30 Hrs",
        "",
        "Mgtr. Karen Basfi-fer Obregón",
        "MTC6"
    )
    object MTC7:Schedule(
        "Herramientas de apoyo que promueven estilos de vida saludables para el cambio de comportamiento en la prevención de enfermedades crónicas",
        "Sala 5 Claudio Cordero - Facultad de Economía",
        "12:00 a 12:30 Hrs",
        "",
        "Dra. Adriana Hernández Santana",
        "MTC7"
    )
    object MTC8:Schedule(
        "Prevención y tratamiento de los trastornos de la conducta alimentaria",
        "Sala 6 Las Monjas - Facultad de Economía\n",
        "12:00 a 12:30 Hrs",
        "",
        "Lcda. Ana Maria Malo Alvarado",
        "MTC8"
    )
    object MTC9:Schedule(
        "Transformando entornos: Experiencia de implementación de un kiosco, bar y huerta agroecológica urbana en una universidad pública para la formación de profesionales de la salud y la comunidad en general",
        "Sala 7 Auditorio Ex - Ciencias Químicas ",
        "12:00 a 12:30 Hrs",
        "",
        "Prof. Beatriz Andrea Graciano",
        "MTC9"
    )
    object CLAUSURA:Schedule(
        "Clausura",
        "Sala 1 Teatro Carlos Cueva Tamariz",
        "12:30 a 13:00 Hrs",
        "",
        "Agencia Organizadora SLAN 2023",
        "CLAUSURA"
    )
}