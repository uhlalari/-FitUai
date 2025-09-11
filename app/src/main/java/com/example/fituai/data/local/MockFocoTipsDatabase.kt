package com.example.fituai.data.local

/**
 * Mock com 30 dicas para o banner "Foco".
 * Cada item contém: título, explicação de importância e como aplicar agora.
 */

data class DicaFoco(
    val title: String,
    val why: String,
    val how: List<String>,
    val note: String? = null
)

object MockFocoTipsDatabase {

    val tips: List<DicaFoco> = listOf(
        DicaFoco(
            title = "Constância vence intensidade",
            why = "Treinar forte de vez em quando não gera resultado. O corpo responde a estímulos regulares, mesmo que pequenos. É a constância que constrói força, saúde e estética.",
            how = listOf(
                "Defina uma meta mínima diária (ex: 10 min de caminhada).",
                "Cumpra essa meta mesmo nos dias de preguiça.",
                "Aumente aos poucos, quando sentir natural."
            ),
            note = "O segredo é não parar. Intensidade vem depois."
        ),
        DicaFoco(
            title = "Meta diária simples",
            why = "Metas muito grandes geram frustração. Uma meta pequena e clara é mais fácil de cumprir e gera sensação de vitória.",
            how = listOf(
                "Escolha 1 ação simples por dia (ex: beber 1 copo de água ao acordar).",
                "Marque como concluído no app.",
                "Sinta a satisfação de cumprir diariamente."
            )
        ),
        DicaFoco(
            title = "Comece pelo mínimo",
            why = "Esperar o 'momento perfeito' leva à procrastinação. Começar pequeno cria embalo e elimina desculpas.",
            how = listOf(
                "Se não quiser treinar 1h, faça 5 min.",
                "Se não der para preparar a refeição ideal, escolha a opção menos pior.",
                "O mínimo hoje ainda é melhor que nada."
            )
        ),
        DicaFoco(
            title = "Use lembretes visuais",
            why = "O ambiente influencia mais do que a força de vontade. Gatilhos visuais reforçam o hábito sem esforço.",
            how = listOf(
                "Deixe a garrafa de água visível na mesa.",
                "Deixe o tênis pronto na porta.",
                "Fixe uma frase motivacional curta no espelho."
            )
        ),
        DicaFoco(
            title = "Ritual pré-treino",
            why = "Ter uma sequência fixa antes de treinar cria associação mental: seu corpo entende que é hora de agir.",
            how = listOf(
                "Exemplo: trocar de roupa, colocar fone, ligar a playlist.",
                "Repita sempre na mesma ordem.",
                "Logo o ritual vira gatilho automático."
            )
        ),
        DicaFoco(
            title = "Divida o grande em pedaços",
            why = "Metas longas assustam. Quebrar em partes menores dá clareza e mantém motivação.",
            how = listOf(
                "Se a meta é perder 10kg, foque nos primeiros 2kg.",
                "Se o objetivo é correr 10km, comece com 1km contínuo.",
                "A cada conquista, redefina a próxima etapa."
            )
        ),
        DicaFoco(
            title = "Anote para enxergar progresso",
            why = "A evolução é lenta e às vezes imperceptível. Registrar mostra que você está avançando, mesmo quando parece parado.",
            how = listOf(
                "Anote treinos, pesos, medidas ou fotos mensais.",
                "Compare registros antigos a cada 4 semanas.",
                "Use isso como combustível para continuar."
            )
        ),
        DicaFoco(
            title = "Planeje o treino no calendário",
            why = "Compromissos marcados têm mais chance de serem cumpridos. Tratar o treino como reunião importante evita desculpas.",
            how = listOf(
                "Marque o treino no calendário do celular.",
                "Ative lembrete 1h antes para se preparar.",
                "Não remarca: cumpre como compromisso de trabalho."
            )
        ),
        DicaFoco(
            title = "Foque no hoje",
            why = "Pensar só no resultado final pode desmotivar. O que importa é vencer o dia de hoje, e amanhã repetir o processo.",
            how = listOf(
                "Pergunte-se: o que posso fazer AGORA que me aproxima do meu objetivo?",
                "Execute essa pequena ação hoje.",
                "Amanhã repita."
            )
        ),
        DicaFoco(
            title = "Treine mesmo sem vontade",
            why = "A disciplina começa quando a motivação acaba. Treinar sem vontade fortalece o hábito e a confiança.",
            how = listOf(
                "Nos dias ruins, reduza a carga ou tempo.",
                "Faça apenas o básico (5–10 min).",
                "O importante é não quebrar a corrente."
            )
        ),
        DicaFoco(
            title = "Visualize o resultado",
            why = "O cérebro responde bem a imagens mentais. Visualizar o objetivo aumenta motivação e reduz desistências.",
            how = listOf(
                "Feche os olhos e imagine você atingindo sua meta.",
                "Sinta a energia dessa conquista.",
                "Lembre-se dessa imagem quando bater preguiça."
            )
        ),
        DicaFoco(
            title = "Crie recompensas saudáveis",
            why = "O cérebro gosta de recompensas. Associar treino e disciplina a prêmios positivos reforça o hábito.",
            how = listOf(
                "Exemplo: após 1 semana de constância, veja um filme.",
                "Após 1 mês, compre uma roupa de treino nova.",
                "Evite usar comida como prêmio."
            )
        ),
        DicaFoco(
            title = "Estabeleça micro-vitórias",
            why = "Celebrar pequenas conquistas aumenta dopamina e mantém a chama acesa para continuar.",
            how = listOf(
                "Comemorou subir a carga? Registre.",
                "Conseguiu treinar 3x na semana? Celebre.",
                "Cada passo conta como vitória."
            )
        ),
        DicaFoco(
            title = "Use a regra dos 5 minutos",
            why = "A mente cria resistência a tarefas longas. Se começar por 5 minutos, normalmente você continua.",
            how = listOf(
                "Diga a si mesmo: ‘vou só começar 5 min’.",
                "Inicie o treino ou preparo da refeição.",
                "Na maioria das vezes, você seguirá além dos 5."
            )
        ),
        DicaFoco(
            title = "Tenha um parceiro de treino",
            why = "Compromisso social aumenta responsabilidade. Quando alguém espera por você, a chance de faltar cai muito.",
            how = listOf(
                "Combine treinos com um amigo.",
                "Se não for possível, compartilhe metas pelo app.",
                "Relatar resultados já cria sensação de compromisso."
            )
        ),
        DicaFoco(
            title = "Elimine as desculpas antes",
            why = "A maior parte das falhas acontece por obstáculos simples: roupa suja, falta de tempo, sem comida pronta.",
            how = listOf(
                "Deixe a roupa separada na noite anterior.",
                "Prepare marmitas no fim de semana.",
                "Defina horário fixo para treinar."
            )
        ),
        DicaFoco(
            title = "Lembre-se do seu 'porquê'",
            why = "Motivação superficial não sustenta. Ter um motivo pessoal claro dá sentido ao esforço.",
            how = listOf(
                "Escreva seu ‘porquê’ (saúde, autoestima, energia).",
                "Leia em dias de desânimo.",
                "Reforce a conexão emocional com a meta."
            )
        ),
        DicaFoco(
            title = "Transforme em rotina",
            why = "Quando a ação vira hábito, não precisa mais de força de vontade. O automático resolve.",
            how = listOf(
                "Escolha sempre o mesmo horário para treinar.",
                "Associe treino a algo fixo (após café, após trabalho).",
                "Repita até virar parte natural do dia."
            )
        ),
        DicaFoco(
            title = "Não espere motivação",
            why = "Motivação é instável, disciplina é estável. Quem espera motivação não age; quem age, encontra motivação no caminho.",
            how = listOf(
                "Estabeleça horário fixo.",
                "Siga o plano mesmo sem vontade.",
                "Ao terminar, registre a sensação positiva."
            )
        ),
        DicaFoco(
            title = "Compare consigo mesmo",
            why = "Comparar com outros desmotiva. A referência deve ser a sua própria evolução.",
            how = listOf(
                "Tire fotos mensais.",
                "Registre medidas e cargas.",
                "Olhe para trás e veja o quanto já andou."
            )
        ),
        DicaFoco(
            title = "Quebre a inércia",
            why = "O mais difícil é começar. Uma pequena ação gera embalo e facilita continuar.",
            how = listOf(
                "Coloque a roupa de treino.",
                "Saia de casa mesmo sem vontade.",
                "O resto flui automaticamente."
            )
        ),
        DicaFoco(
            title = "Rotina de manhã = menos desculpas",
            why = "Treinar cedo garante que imprevistos do dia não atrapalhem. É uma forma de blindar sua constância.",
            how = listOf(
                "Durma mais cedo para acordar com energia.",
                "Separe roupa e garrafinha na noite anterior.",
                "Treine antes do trabalho/estudos."
            )
        ),
        DicaFoco(
            title = "Recomece sempre",
            why = "Todos falham em algum momento. O que diferencia quem chega lá é a rapidez em recomeçar.",
            how = listOf(
                "Errou a dieta? Volte na próxima refeição.",
                "Perdeu um treino? Compense no próximo.",
                "Não espere a segunda-feira: recomece agora."
            )
        ),
        DicaFoco(
            title = "Assuma a identidade",
            why = "Não basta ‘fazer academia’, você precisa se ver como alguém saudável. A identidade guia o comportamento.",
            how = listOf(
                "Diga a si mesmo: sou uma pessoa ativa.",
                "Escolha hábitos que confirmem isso (subir escadas, caminhar).",
                "Cada ação reforça a identidade."
            )
        ),
        DicaFoco(
            title = "Tenha plano B",
            why = "Imprevistos acontecem. Quem tem alternativa não perde o ritmo.",
            how = listOf(
                "Sem tempo para a academia? Faça treino em casa.",
                "Choveu? Caminhe dentro do prédio ou alongue.",
                "Viaja? Use exercícios com peso corporal."
            )
        ),
        DicaFoco(
            title = "Use 'não negociáveis'",
            why = "Quando o hábito é tratado como obrigação, não há espaço para negociar com a preguiça.",
            how = listOf(
                "Escolha 1–2 hábitos diários não negociáveis (ex: beber água, 10 min de treino).",
                "Cumpra sempre, independente da vontade.",
                "Isso constrói disciplina verdadeira."
            )
        ),
        DicaFoco(
            title = "Celebre o processo, não só o resultado",
            why = "Resultados demoram, mas o processo acontece todo dia. Aprender a valorizar o caminho mantém a motivação viva.",
            how = listOf(
                "Reconheça cada treino feito como vitória.",
                "Agradeça ao corpo por aguentar o esforço.",
                "Curta a jornada, não só a linha de chegada."
            )
        ),
        DicaFoco(
            title = "Pense longo prazo",
            why = "Saúde e estética não são corrida de 100m, são maratona. A visão de longo prazo evita pressa e desistências.",
            how = listOf(
                "Veja o treino como investimento de anos.",
                "Aceite que pequenas quedas não afetam o todo.",
                "Construa hábitos sustentáveis, não atalhos."
            )
        )
    )
}
