package com.example.fituai.data.local

/**
 * Mock com 30 dicas para o banner "Mundo do esporte".
 * Cada item contém: título, explicação de importância e como aplicar agora.
 */

data class DicaEsporte(
    val title: String,
    val why: String,
    val how: List<String>,
    val note: String? = null
)

object MockSportsTipsDatabase {

    val tips: List<DicaEsporte> = listOf(
        DicaEsporte(
            title = "Aquecimento dinâmico",
            why = "Muita gente pula o aquecimento achando que é perda de tempo, mas ele é um dos principais fatores de prevenção de lesões. Movimentos leves e dinâmicos aumentam a circulação, ativam a mobilidade articular e preparam os músculos para esforços mais intensos. Sem essa preparação, o corpo leva um ‘choque’ quando você começa o treino pesado, o que aumenta o risco de distensões ou torções.",
            how = listOf(
                "30 segundos de polichinelos",
                "30 segundos de corrida no lugar",
                "10 agachamentos sem peso"
            ),
            note = "Em apenas 2 minutos você já estará com o corpo pronto para treinar com mais segurança e desempenho."
        ),
        DicaEsporte(
            title = "Alongamento pós-treino",
            why = "Após o treino, a musculatura tende a ficar encurtada e tensa. Alongar nesse momento ajuda a restaurar a amplitude dos movimentos, reduzir dores musculares tardias e proporcionar uma sensação de relaxamento. Diferente do aquecimento, aqui o objetivo não é ativar, mas sim ‘desligar’ o corpo e acelerar a recuperação.",
            how = listOf(
                "Alongue braços por 20 segundos cruzando-os à frente do peito.",
                "Toque os pés mantendo pernas estendidas por 20 segundos.",
                "Deite-se e abrace os joelhos contra o peito por 20 segundos."
            ),
            note = "Reserve 5 minutos no final do treino e sinta a diferença no dia seguinte."
        ),
        DicaEsporte(
            title = "Equilíbrio entre força e cardio",
            why = "Treinar apenas musculação ou apenas corrida limita seus resultados. A força fortalece músculos, ossos e articulações, prevenindo lesões e mantendo o metabolismo acelerado. Já o cardio melhora o coração, os pulmões e ajuda no controle do peso. A combinação é a fórmula mais eficaz para saúde geral e performance esportiva.",
            how = listOf(
                "3 dias da semana: treino de força (musculação, funcional, pilates).",
                "2 dias da semana: treino cardio (corrida, bike, natação)."
            ),
            note = "Você cria um equilíbrio que cuida tanto da estética quanto da saúde cardiovascular."
        ),
        DicaEsporte(
            title = "Treinos multiarticulares",
            why = "Exercícios que ativam vários músculos ao mesmo tempo aumentam o gasto calórico, otimizam o tempo e estimulam ganhos funcionais (ou seja, força útil para a vida real). Ao invés de treinar apenas músculos isolados em máquinas, prefira movimentos que envolvam o corpo todo.",
            how = listOf(
                "Inclua:",
                "Agachamento (pernas, glúteos, core)",
                "Flexão de braço (peito, ombros, tríceps, core)",
                "Prancha (core e estabilidade postural)",
                "Barra fixa (costas, braços, pegada)"
            ),
            note = "Faça deles a base do seu treino e veja a evolução acelerada."
        ),
        DicaEsporte(
            title = "Descanso ativo",
            why = "O descanso é parte fundamental do treino, pois é quando os músculos se recuperam e crescem. Mas descansar não significa ficar totalmente parado. Movimentos leves melhoram a circulação, ajudam a remover toxinas acumuladas e mantêm o corpo ativo sem sobrecarga.",
            how = listOf(
                "Nos dias de descanso:",
                "Caminhe 15 a 20 minutos",
                "Faça alongamentos ou yoga",
                "Experimente mobilidade articular leve"
            ),
            note = "Assim você acelera a recuperação e ainda mantém o hábito de se movimentar."
        ),
        DicaEsporte(
            title = "Caminhada acelerada pós-refeição",
            why = "Uma simples caminhada de 10 minutos depois de comer ajuda na digestão e evita picos de glicose no sangue, o que é especialmente importante para quem busca controle de peso e energia estável ao longo do dia. É um hábito simples que gera benefícios metabólicos reais.",
            how = listOf(
                "Terminou o almoço ou jantar? Caminhe por 10 minutos em ritmo moderado, como se estivesse com pressa.",
                "Se não puder sair, suba escadas ou ande dentro de casa."
            ),
            note = "O corpo agradece."
        ),
        DicaEsporte(
            title = "HIIT de 4 minutos",
            why = "O treino intervalado de alta intensidade (HIIT) é altamente eficiente: em poucos minutos você acelera o metabolismo, queima calorias e melhora a resistência cardiovascular. Estudos mostram que até 4 minutos bem feitos podem trazer ganhos comparáveis a treinos longos de cardio moderado.",
            how = listOf(
                "Faça o protocolo Tabata:",
                "20 segundos de corrida no lugar (ou burpees/polichinelos)",
                "10 segundos parado",
                "Repita 8 vezes"
            ),
            note = "Total: 4 minutos. Rápido, intenso e eficaz."
        ),
        DicaEsporte(
            title = "Hidratação estratégica",
            why = "A perda de apenas 2% de água corporal já compromete força, resistência e foco. Durante o exercício, a transpiração acelera essa perda, e muitos só percebem quando já estão cansados demais.",
            how = listOf(
                "1 copo de água 30 minutos antes do treino",
                "Pequenos goles a cada 15 minutos durante",
                "1 copo logo após terminar"
            ),
            note = "Simples, mas suficiente para manter o corpo funcionando no auge."
        ),
        DicaEsporte(
            title = "Banana + água de coco: isotônico natural",
            why = "Durante treinos longos ou intensos, o corpo perde eletrólitos (como potássio e sódio) junto com a água. A banana repõe potássio, enquanto a água de coco hidrata e devolve minerais essenciais. Essa combinação simples previne câimbras e favorece a recuperação muscular.",
            how = listOf(
                "Após o treino, consuma:",
                "1 banana",
                "200 ml de água de coco"
            ),
            note = "Natural, barato e altamente eficiente para recuperação."
        ),
        DicaEsporte(
            title = "Micro-objetivos diários",
            why = "Metas grandes como ‘perder 10 kg’ ou ‘correr uma maratona’ podem desmotivar, porque parecem distantes demais. O segredo é pensar pequeno: objetivos diários fáceis de cumprir criam consistência, e a consistência gera resultado.",
            how = listOf(
                "Hoje: caminhar 8 mil passos",
                "Amanhã: 3 séries de 15 flexões",
                "Depois: alongamento de 10 minutos"
            ),
            note = "Assim, cada dia é uma vitória que empilha disciplina sem pesar."
        ),
        DicaEsporte(
            title = "Sono de qualidade: o treino invisível",
            why = "Durante o sono profundo o corpo libera hormônios fundamentais para reparo muscular, equilíbrio hormonal e até controle do apetite. Quem dorme pouco tende a ter mais fadiga, dificuldade de concentração e recuperação mais lenta dos treinos. É como tentar progredir com o ‘treino invisível’ incompleto.",
            how = listOf(
                "Durma 7–9 horas por noite.",
                "Desligue telas 1h antes de deitar.",
                "Mantenha o quarto escuro e silencioso."
            ),
            note = "Com sono de qualidade, cada treino rende mais."
        ),
        DicaEsporte(
            title = "Foam roller: massagem que você mesmo faz",
            why = "O rolo de liberação miofascial ajuda a reduzir tensões musculares, melhora a circulação e aumenta a mobilidade articular. É como ter uma massagem esportiva rápida em casa, que previne dores e acelera a recuperação.",
            how = listOf(
                "Passe o rolo:",
                "1 min nas panturrilhas",
                "1 min nas coxas",
                "1 min nas costas"
            ),
            note = "Em apenas 3 minutos você já sente músculos mais soltos."
        ),
        DicaEsporte(
            title = "Banho frio pós-treino",
            why = "A água fria reduz inflamação e ajuda a controlar microlesões causadas pelo exercício intenso. Atletas de elite usam esse recurso há décadas para acelerar a recuperação. Além disso, ativa o sistema nervoso, dando uma sensação de disposição.",
            how = listOf(
                "Finalize o banho com 2 min de água fria nas pernas e braços.",
                "Se aguentar, expanda para o corpo todo."
            ),
            note = "O choque inicial passa rápido e os benefícios ficam."
        ),
        DicaEsporte(
            title = "Carboidrato rápido antes do treino",
            why = "O corpo precisa de energia imediata para performar bem. O carboidrato de fácil digestão garante combustível rápido, sem pesar no estômago. Sem ele, você pode sentir queda de energia e rendimento.",
            how = listOf(
                "Coma 1 banana ou 1 fatia de pão integral 30 min antes do treino.",
                "Evite alimentos gordurosos, que são de digestão lenta."
            ),
            note = "Assim você entra no treino com mais disposição."
        ),
        DicaEsporte(
            title = "Proteína: tijolo da recuperação",
            why = "A proteína é o material de construção dos músculos. Após o treino, o corpo precisa dela para reparar as fibras que foram ‘quebradas’ durante o esforço. Sem esse aporte, a recuperação é lenta e o ganho de força fica comprometido.",
            how = listOf(
                "Inclua:",
                "Ovos mexidos",
                "Iogurte natural",
                "Shake de whey protein"
            ),
            note = "Consuma até 1h após o treino para maximizar resultados."
        ),
        DicaEsporte(
            title = "Refeições leves à noite",
            why = "Comer pesado antes de dormir atrapalha a qualidade do sono, que é fundamental para a recuperação. Refeições ricas em gordura e açúcar podem causar refluxo, agitação e dificultar o descanso.",
            how = listOf(
                "No jantar, escolha:",
                "Sopa leve",
                "Omelete",
                "Iogurte com frutas"
            ),
            note = "Esses alimentos são nutritivos e não pesam no estômago."
        ),
        DicaEsporte(
            title = "Café como pré-treino natural",
            why = "A cafeína estimula o sistema nervoso, aumenta o estado de alerta e melhora a percepção de esforço. É um recurso simples, barato e com efeito comprovado para dar aquele ‘up’ antes do treino.",
            how = listOf(
                "Tome 1 xícara de café preto 30 min antes de treinar.",
                "Evite adicionar muito açúcar.",
                "Não consuma perto da hora de dormir."
            ),
            note = "A energia vem rápido e o treino rende mais."
        ),
        DicaEsporte(
            title = "Varie seus treinos para evoluir",
            why = "Repetir sempre o mesmo exercício pode causar platô, onde o corpo se acostuma e os resultados travam. A variação também reduz risco de lesão por sobrecarga e mantém a motivação alta.",
            how = listOf(
                "Troque corrida por bike 1x na semana.",
                "Alterne séries de musculação com exercícios funcionais.",
                "Inclua atividades diferentes a cada mês."
            ),
            note = "A novidade mantém o corpo e a mente ativos."
        ),
        DicaEsporte(
            title = "Música como combustível",
            why = "Estudos mostram que músicas animadas reduzem a percepção de esforço, aumentam a motivação e podem melhorar até 15% o desempenho. É um recurso simples que transforma a energia do treino.",
            how = listOf(
                "Crie uma playlist com 5 músicas que te animam.",
                "Use fones leves e seguros.",
                "Reserve essa playlist só para treinar, criando uma associação positiva."
            )
        ),
        DicaEsporte(
            title = "Diário de progresso",
            why = "Registrar seus treinos cria consciência, permite medir evolução e reforça a motivação. Pequenos avanços que passam despercebidos no dia a dia se tornam visíveis quando você olha para trás.",
            how = listOf(
                "Anote no celular a carga levantada, o tempo de corrida ou a distância percorrida.",
                "Tire uma foto mensal para comparar.",
                "Celebre cada progresso, por menor que pareça."
            )
        ),
        DicaEsporte(
            title = "Micro-objetivos: disciplina em pílulas",
            why = "Pensar em metas grandes, como ‘correr uma maratona’ ou ‘perder 10kg’, pode gerar ansiedade e desmotivação. Quando você quebra o objetivo em micro-passos, o cérebro entende cada conquista como vitória, liberando dopamina e reforçando a disciplina.",
            how = listOf(
                "Hoje: caminhe 10 min.",
                "Amanhã: faça 20 agachamentos.",
                "Depois: alongue por 5 min."
            ),
            note = "Cada passo parece pequeno, mas juntos constroem resultados gigantes."
        ),
        DicaEsporte(
            title = "Treino como lazer",
            why = "Exercitar-se não precisa ser uma obrigação chata. Quando o treino vira lazer, ele se encaixa naturalmente na rotina. O componente social também aumenta adesão e prazer, reduzindo a chance de desistência.",
            how = listOf(
                "Combine uma corrida leve com um amigo.",
                "Faça trilhas de fim de semana.",
                "Pedale até uma cafeteria."
            ),
            note = "Transforme o movimento em experiência agradável, não em peso."
        ),
        DicaEsporte(
            title = "Treino variado, corpo desperto",
            why = "Sempre repetir os mesmos movimentos sobrecarrega músculos e articulações, além de reduzir o estímulo mental. A variação traz novos desafios, mantém a evolução e torna a prática mais divertida.",
            how = listOf(
                "Substitua corrida por natação em 1 treino da semana.",
                "Troque musculação por treino funcional a cada 15 dias.",
                "Experimente pular corda ou dançar como cardio alternativo."
            )
        ),
        DicaEsporte(
            title = "Música como gatilho de performance",
            why = "A música acelera batimentos, reduz a percepção de esforço e gera foco. Ouvir faixas animadas durante o treino cria um gatilho mental: o cérebro associa a playlist ao ‘modo ativo’, reforçando o hábito.",
            how = listOf(
                "Monte uma playlist de 30 minutos com batidas rápidas.",
                "Use essa playlist somente durante o treino.",
                "Ao ouvir, seu corpo já entra no ritmo."
            )
        ),
        DicaEsporte(
            title = "Diário de progresso: sua linha do tempo",
            why = "Ver a evolução escrita ou em imagens dá clareza do quanto você avançou. Isso reforça a motivação e ajuda a ajustar estratégias. Pequenos avanços, quando registrados, ganham peso e valor.",
            how = listOf(
                "Anote carga, repetições ou tempo ao final de cada treino.",
                "Tire uma foto por mês no mesmo local e luz.",
                "Revise a cada 3 meses e celebre os avanços."
            )
        ),
        DicaEsporte(
            title = "Tênis certo, treino seguro",
            why = "O calçado adequado absorve impacto, melhora a biomecânica e reduz risco de lesões em joelhos e tornozelos. Um tênis errado pode comprometer até sua postura.",
            how = listOf(
                "Para corrida: tênis leve e com amortecimento.",
                "Para musculação: tênis firme, de sola reta e estável.",
                "Avalie trocar seu tênis a cada 600–800 km de uso."
            )
        ),
        DicaEsporte(
            title = "Técnica antes da carga",
            why = "Muitos querem evoluir rápido e aumentam peso sem ajustar a execução. Isso pode gerar lesões e travar progresso. A técnica correta recruta melhor os músculos e torna o treino mais eficaz.",
            how = listOf(
                "Grave um vídeo do seu agachamento ou supino.",
                "Compare com a execução correta.",
                "Ajuste antes de subir a carga."
            )
        ),
        DicaEsporte(
            title = "Progresso seguro: regra dos 10%",
            why = "O corpo precisa de adaptação gradual. Aumentar muito rápido distância ou peso eleva o risco de lesões por sobrecarga. A regra dos 10% garante evolução consistente e segura.",
            how = listOf(
                "Corre 5 km hoje? Vá para no máximo 5,5 km na próxima semana.",
                "Levanta 40 kg? Suba apenas para 44 kg."
            ),
            note = "Assim o progresso é constante sem quebrar o corpo."
        ),
        DicaEsporte(
            title = "Ouça o seu corpo",
            why = "Dor aguda, fadiga excessiva e tontura são sinais de alerta. Ignorar pode levar a lesões que te afastam dos treinos por semanas. Saber respeitar limites é inteligência esportiva.",
            how = listOf(
                "Diferencie: desconforto muscular é normal, dor articular não.",
                "Se sentir dor intensa, interrompa o treino.",
                "Ajuste carga ou intensidade no próximo treino."
            )
        ),
        DicaEsporte(
            title = "Check-up anual: treino com segurança",
            why = "Exames de rotina e avaliação física ajudam a identificar riscos, acompanhar evolução e garantir que seu treino está alinhado com sua saúde. A prevenção sempre custa menos que a recuperação.",
            how = listOf(
                "Faça exames laboratoriais 1x por ano.",
                "Agende consulta médica antes de iniciar treinos intensos.",
                "Use os resultados para personalizar sua rotina."
            )
        )
    )
}
