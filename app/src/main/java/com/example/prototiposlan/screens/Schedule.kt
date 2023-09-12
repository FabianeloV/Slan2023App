package com.example.prototiposlan.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
sealed class Schedule(
    val event: String,
    val ubication: String,
    val hour: String,
    val description: String,
    var showDialog:MutableState<Boolean> = mutableStateOf(false)
) {
    object T2 : Schedule(
        "El Código Internacional de Comercialización de Sucedáneos de Leche Materna (CICSLM), su impacto en las políticas de Lactancia materna y Aplicación del Conjunto de Instrumentos para su Monitoreo",
        "Sala 3 Arquitectura",
        "8:00 a 13:00 Hrs",
        "Objetivos del taller: Este curso-taller permitirá a los participantes adquirir una comprensión del Código (CICSLM) y su impacto en las políticas de lactancia materna; desarrollar habilidades prácticas para evaluar y abordar las violaciones mediante el paquete de instrumentos del NetCode. Además, fomentará la colaboración y el intercambio de experiencias entre los participantes, lo que facilitará la creación de una red de apoyo y promoción de la lactancia materna en diversos entornos y contextos. Público Objetivo del taller: Profesionales de la salud, personal de atención materno-infantil, representantes de gobiernos y organizaciones no gubernamentales, fabricantes de productos relacionados con la alimentación infantil, y madres y padres interesados en proteger los derechos de los bebés y promover la lactancia materna. El Código Internacional de Comercialización de Sucedáneos de Leche Materna es una recomendación crucial promulgada por la OMS, que busca proteger y promover la lactancia materna, asegurando que los sustitutos de la leche materna no se promocionen de manera inapropiada ni interfieran con esta opción de alimentación óptima para los bebés. Sin embargo, la falta de conocimiento y comprensión sobre el Código ha llevado a violaciones frecuentes y prácticas comerciales engañosas. Por tal motivo, es fundamental proporcionar a los participantes el conocimiento y las herramientas necesarias para su comprensión y que sean parte de su vigilancia y cumplimiento."
    )

    object T3 : Schedule(
        "Métodos cualitativos en investigaciones nutricionales",
        "Sala 4 Hugo Ordóñez",
        "8:15 a 12:15 Hrs",
        "Objetivos del taller: Brindar conocimientos y destrezas que permitan realizar investigaciones cualitativas en nutrición, salud y sistemas alimentarios con un enfoque basado en comportamiento humano (ej., conocimientos, actitudes y prácticas) y sociedad (ej. normas culturales, instituciones). Público Objetivo del taller: estudiantes y profesionales en nutrición, salud y sistemas alimentarios que (i) desean conocer sobre la aplicación de métodos cualitativos en investigación, y también para aquellas personas que (ii) quieren ampliar conocimientos y mejorar capacidades en metodología cualitativa. El taller está dividido en dos partes. Desde un enfoque en la teoría fundamentada (grounded theory), el taller presenta en forma interactiva y con ejercicios, las tres fases de la investigación cualitativa: planificación, trabajo de campo y análisis de los datos. Entre los temas que se discuten están: la identificación y selección de participantes, recolección de datos a través de entrevistas, grupos focales y otros métodos, codificación y análisis de datos y preparación de informes, publicaciones y reportes a la comunidad. El taller incluye un ejercicio reflexivo sobre los roles, la ética y la relación entre investigadores y las personas investigadas. Se ofrecen conceptos, herramientas y actividades participativas para entender y trabajar con una perspectiva psicosocial. Finalmente, se comparten casos de estudio acompañado de ejercicios en grupo."
    )

    object T1 : Schedule(
        "La aplicación de investigación participativa en nutrición",
        "Sala 2 Aula Magna Mario Vintimilla ",
        "9:00 a 13:00 Hrs",
        "Objetivos del taller: 1. Fortalecer la capacidad de implementar investigación participativa en nutrición. 2. Promover principios de investigación que produce resultados útiles para las poblaciones que participan de la misma. 3. Implementar ejemplos de la investigación para la promoción y prevención de las enfermedades relacionadas a la nutrición. Este taller utilizará actividades prácticas complementadas con bases teóricas y ejemplos concretos para fortalecer la capacidad de implementar investigación participativa en nutrición. Abordaremos tres fases de investigación participativa: (1) conceptualización y desarrollo de un proyecto; (2) colecta de datos con herramientas participativas; y (3) devolución de resultados y compartir de conocimientos. El taller nace de la necesidad de implementar procesos de investigación que cumplan con varios criterios: son culturalmente apropiados y respetuosos; responden a prioridades y generan resultados útiles para las comunidades participantes; utilizan herramientas aptas para poblaciones con poca educación formal o con barreras de idioma, y que reducen la carga cognitiva y/o carga de tiempo sobre los participantes; implementan métodos que son enriquecedores para las comunidades e individuos que participan. Las herramientas participativas presentadas incluyen: adaptación de “pile sorting” (método de clasificación de imágenes) para usos en nutrición; recordatorio 24 horas visual y colectivo; aplicación en nutrición de “backcasting” (método narrativo para desvelar perspectivas endógenas de cómo se produce un resultado (ej. diabetes)); observación participante; y etnografía enfocada. De estas herramientas, algunas serán demostradas de manera práctica (“participativa”) en el taller, y las otras a través de ejemplos concretos desde experiencias con comunidades rurales en Ecuador y comunidades indígenas en Canadá. Estas se complementan con fundamentos teóricos sobre los objetivos de la investigación participativa, el análisis de datos de las herramientas presentadas, y pautas para apoyar el proceso de diseñar un proyecto participativo (o integrar componentes participativos dentro de proyectos actuales)."
    )

    object T5: Schedule(
        "Orientaciones sobre lactancia materna, técnicas de extracción, almacenamiento y alimentación del lactante con leche materna extraída",
        "Sala 3 Arquitectura",
        "9:00 a 12:00 Hrs",
        "Institución Organizadora: Pontificia Universidad Católica del Ecuador Objetivos del taller: Sensibilizar a los participantes sobre la importancia de la lactancia materna Fortalecer las competencias de asesoría en lactancia materna para ayudar a las madres a amamantar correctamente. Reforzar las prácticas sobre extracción manual de leche materna usando simuladores de entrenamiento. Reasegurar los conocimientos de los participantes en relación a las técnicas de alimentación del lactante con leche materna extraída. Público Objetivo del taller: Estudiantes y profesionales de la salud que en su práctica diaria estén en contacto con mujeres en periodo de lactancia (Estudiantes y profesionales de nutrición, enfermería, psicología, medicina, obstetricia, dietistas) Este taller brinda información sobre los numerosos beneficios que la lactancia materna ofrece tanto a los niños, a las madres, a la sociedad y al medio ambiente. Se proporcionará información sobre las situaciones que requieren que una mujer extraiga la leche materna, cómo apoyar la producción exitosa de leche durante periodos de ausencia y cómo garantizar una producción efectiva de leche y lactancia materna a largo plazo. Además, el taller tiene como objetivo fortalecer las competencias de los estudiantes o profesionales de la salud sobre técnicas efectivas y seguras para extraer leche materna, abordando situaciones que requieren esta práctica y para ofrecer apoyo sólido a las mujeres en periodo de lactancia. Para la verificar de las competencias se usan instrumentos como los ECOE exámenes clínicos objetivos por competencias que permiten que cada participante evalúe su desempeño ante situaciones prácticas simuladas y donde ponen de manifiesto su razonamiento clínico, habilidades y la comunicación entre la persona que brinda la asesoría y la mujer en periodo de lactancia que recibe la información. Este taller permitirá actualizar los conocimientos con evidencia científica actualizada y a través de los procesos de sensibilización, motivar a los participantes en ser promotores activos de la lactancia materna."
    )

    object T6: Schedule(
        "Estimación de ingesta: Método de Recordatorio, herramientas de análisis y emparejamiento de tablas de composición",
        "Sala 4 Hugo Ordoñéz",
        "9:00 a 12:00 Hrs",
        "Materiales y espacios requeridos para la realización del taller: Tablero, infocus, cada participante puede venir con su computadora con instalación de R y RStudio. Número de cupos ofertados: 30 Institución Organizadora: USFQ - ISYN Objetivos del taller: - Entender los métodos de estimación de ingesta nutricional, - Introducción al uso de nuevas soluciones tecnológicas para emparejar tablas de composición y encuestas Público Objetivo del taller: Personas familiarizadas con cuestionarios de ingesta Personas interesadas en el análisis de datos Breve resumen de su propuesta de taller Evaluar la ingesta dietaria es una tarea fundamental en nutrición poblacional y llegar a estimaciones precisas siempre un reto. En fundamental para analizar asociaciones entre la dieta y la salud. Por ellos varios métodos estandarizados existen para obtener estimados de alimentos consumidos y las porciones ingeridas. Dentro de los métodos mencionaremos métodos prospectivos (registro por pesada de alimentos) y retrospectivos. Ahí se encuentran los cuestionarios de frecuencia de consumo (CFC), el recordatorio de 24 horas (R24h) y las historias dietarias. El R24h y los CFC son los principalmente utilizados en la investigación en nutrición. Sin embargo, pese a los esfuerzos que existen en el levantamiento de información, el emparejamiento con información de tablas de composición es seguramente el más pesado en tiempo y sujeto a errores variados. Detallaremos metodologías claras de análisis de información textual y técnicas de emparejamiento de texto para juntar esta información con bases de datos de composición de alimentos."
    )

    object T4: Schedule(
        "Estimación de la composición química de recetas utilizando bases de datos de composición de alimentos",
        "Sala 2 Aula Magna Mario Vintimilla",
        "9:00 a 16:00 Hrs",
        "Institución Organizadora: SLAN (Sociedad Latinoamericana de Nutrición) Brasil Foods, FORC, USR, FAPESP, Costa RicaFoods, LATINFOODS Objetivos del taller: Estimar la composición química de preparaciones de consumo usual en la población mediante los métodos de cálculo directo, indirecto y mixto, usando una base de datos de composición de alimentos nacional y aplicando factores (fracción comestible, conversión y retención de nutrientes), siguiendo los parámetros de INFOODS/FAO. Público Objetivo del taller: Estudiantes (nutrición e ingeniería de alimentos con conocimientos previos sobre uso de tablas de composición de alimentos y cálculo de valor nutritivo), profesionales de la salud e investigadores, profesionales de carreras afines con composición de alimentos. El taller tendrá dos secciones, una sección teórica con una duración de dos horas donde se abordarán algunos temas relacionados a la composición de alimentos, cálculo de preparaciones, normativas, formularios, publicaciones, entre otros. Además, una sección práctica con una duración de cuatro horas para realizar el cálculo de diferentes preparaciones empleando los métodos directo, indirecto y mixto."
    )

    object Conf: Schedule(
        "Conferencia inaugural y cóctel de bienvenida",
        "Sala 1 Auditorio Carlos Cueva",
        "18:00 a 20:30 Hrs",
        "Conferencia de apertura y brindis general"
    )

    object Music: Schedule(
        "Música ritmo y Actividad Física",
        "Coliseo y Estadio de la Universidad de Cuenca",
        "7:00 a 7:45 Hrs",
        ""
    )


}