package com.example.fituai.data.local

/**
 * Mock com 30 dicas para o banner "Tecnologia e Saúde".
 * Pensadas para complementar um app que JÁ tem controle de alimentos/macros e água.
 * Cada item contém: título, explicação de importância e como aplicar agora.
 */

data class DicaTechHealth(
    val title: String,
    val why: String,
    val how: List<String>,
    val note: String? = null
)

object MockTechHealthTipsDatabase {

    val tips: List<DicaTechHealth> = listOf(
        DicaTechHealth(
            title = "Zonas de frequência cardíaca no treino",
            why = "Treinar por sensação pode enganar. As zonas de FC calibram a intensidade para queima de gordura, ganho de resistência ou VO2. Isso evita exageros e melhora resultados.",
            how = listOf(
                "Use seu smartwatch para descobrir sua FC máxima estimada.",
                "Durante o cardio, mantenha-se 60–70% para base aeróbica ou 80–90% para tiros.",
                "Revise o gráfico após o treino e ajuste a intensidade."
            ),
            note = "Se possível, faça um teste de campo simples para calibrar suas zonas."
        ),
        DicaTechHealth(
            title = "Cadência na corrida com sensor/relógio",
            why = "Cadência adequada (170–180 ppm) reduz impacto e melhora economia de corrida. Monitorar evita passadas largas e sobrecarga.",
            how = listOf(
                "Ative a métrica de cadência no app de corrida.",
                "Use beeps/compasso musical para manter a frequência.",
                "Aumente a cadência gradualmente (5–10 ppm por mês)."
            )
        ),
        DicaTechHealth(
            title = "Timer de intervalos (Tabata/EMOM) no celular",
            why = "Cronômetros específicos dão precisão ao HIIT, evitando pausas longas ou curtas demais e mantendo a intensidade correta.",
            how = listOf(
                "Baixe/ative um timer de intervalos.",
                "Programe 8x (20s trabalho/10s descanso) ou EMOM de 10–15 min.",
                "Salve presets para sessões rápidas."
            )
        ),
        DicaTechHealth(
            title = "Lembretes de postura e pausas ativas",
            why = "Sedentarismo ocupacional sabota o progresso. Micro-pausas previnem dores, melhoram circulação e clareiam a mente.",
            how = listOf(
                "Programe alertas a cada 50–60 min.",
                "Levante, caminhe 2 min e faça 2 alongamentos guiados pelo app.",
                "Se possível, use um app que vibre no relógio."
            )
        ),
        DicaTechHealth(
            title = "Análise de sono para render mais",
            why = "Sono ruim = recuperação lenta. Dados de sono mostram padrões e ajudam a ajustar horário, luz e rotina noturna.",
            how = listOf(
                "Durma com o relógio por 7 noites.",
                "Identifique horários com mais sono profundo e estabilize sua rotina.",
                "Evite telas 60 min antes de deitar (use filtro de luz azul)."
            )
        ),
        DicaTechHealth(
            title = "HRV (variabilidade da frequência cardíaca) como termômetro",
            why = "HRV baixa costuma indicar fadiga/estresse. Usar HRV para modular a intensidade reduz risco de overtraining.",
            how = listOf(
                "Meça a HRV pela manhã, sempre no mesmo horário.",
                "Se cair muito, faça treino leve/mobilidade.",
                "Se estiver alta, aproveite para treinos intensos."
            ),
            note = "Consistência de horário e ambiente é essencial."
        ),
        DicaTechHealth(
            title = "Integração com balança inteligente",
            why = "Tendências de peso e composição são mais úteis que valores isolados. A integração automatiza e reduz erros.",
            how = listOf(
                "Pareie a balança ao app de saúde.",
                "Pese-se 3–4x/semana, no mesmo horário.",
                "Acompanhe a MÉDIA semanal, não o número diário."
            )
        ),
        DicaTechHealth(
            title = "Checklist digital pré-treino",
            why = "Esquecer garrafa, fone ou toalha vira desculpa para treinos ruins. Um checklist evita frustrações.",
            how = listOf(
                "Crie um checklist no app de notas/lembrantes.",
                "Inclua: fones, toalha, cadeado, documento, pré-treino.",
                "Ative um alerta 20 min antes de sair."
            )
        ),
        DicaTechHealth(
            title = "Automação com NFC/atalhos",
            why = "Remover atritos aumenta a consistência. Um toque ativa música, timer e modo foco, deixando tudo pronto para treinar.",
            how = listOf(
                "Cole uma tag NFC na garrafa/bolsa.",
                "Programe: abrir playlist, iniciar timer, ativar ‘não perturbe’.",
                "Toque a tag ao começar o treino."
            )
        ),
        DicaTechHealth(
            title = "Modo Foco para treinar sem distrações",
            why = "Notificações quebram o ritmo e aumentam a percepção de esforço. Foco melhora a qualidade do treino.",
            how = listOf(
                "Ative ‘Não Perturbe’ ao iniciar o treino.",
                "Permita apenas chamadas de emergência e timer.",
                "Desative após o alongamento final."
            )
        ),
        DicaTechHealth(
            title = "Filmagem de técnica com grade na câmera",
            why = "Vídeo revela desalinhamentos que você não sente. Corrigir técnica evita lesões e melhora recrutamento muscular.",
            how = listOf(
                "Ative a grade da câmera.",
                "Grave de frente e de lado nos básicos (agachamento, supino, terra).",
                "Compare com referências e ajuste pontos-chave."
            )
        ),
        DicaTechHealth(
            title = "Métricas de potência no ciclismo (se disponível)",
            why = "Potência mede trabalho real, independente de vento/terreno. Treinar por zonas de potência acelera evolução.",
            how = listOf(
                "Emparelhe o medidor de potência ao app.",
                "Faça um teste de 20 min para estimar FTP.",
                "Estruture treinos por zonas (Z2 base, Z4 limiar, Z5 VO2)."
            )
        ),
        DicaTechHealth(
            title = "GPS com segurança (compartilhamento ao vivo)",
            why = "Compartilhar rota ao vivo aumenta segurança em corridas e pedais. Útil à noite ou em locais novos.",
            how = listOf(
                "Ative o ‘live tracking’ no app esportivo.",
                "Compartilhe com um contato de confiança.",
                "Defina tempo limite e desligue ao finalizar."
            )
        ),
        DicaTechHealth(
            title = "Widget de treino na tela inicial",
            why = "Um toque para começar reduz atrito e fortalece o hábito. Acesso rápido = mais consistência.",
            how = listOf(
                "Adicione o widget do seu app na tela inicial.",
                "Configure para abrir direto o treino do dia.",
                "Use ícone diferenciado para servir de gatilho visual."
            )
        ),
        DicaTechHealth(
            title = "Templates de treino no app",
            why = "Ter modelos prontos padroniza registro, economiza tempo e melhora a análise de progresso.",
            how = listOf(
                "Crie templates: força total, puxar/empurrar/pernas, HIIT 15'.",
                "Inclua séries, repetições e RPE de referência.",
                "Reaplique e só ajuste cargas."
            )
        ),
        DicaTechHealth(
            title = "RPE (escala de esforço) + registro rápido",
            why = "RPE complementa os números: peso e reps nem sempre contam a história completa. Esforço percebido guia ajustes finos.",
            how = listOf(
                "Ao salvar a série, registre o RPE (6–10).",
                "Se RPE >9, reduza carga/volume na próxima.",
                "Se RPE <7, aumente progressivamente."
            )
        ),
        DicaTechHealth(
            title = "Lembrete de alongamento pós-treino",
            why = "Alongar após a sessão ajuda a recuperar amplitude e relaxar. O lembrete garante que você não pule essa etapa.",
            how = listOf(
                "Programe um alarme recorrente 5 min após o término do treino.",
                "Siga uma rotina guiada de 3–5 exercícios.",
                "Marque como concluído no app."
            )
        ),
        DicaTechHealth(
            title = "Lista de reprodução por fase",
            why = "Música certa no aquecimento, trabalho e volta à calma melhora foco e controle de ritmo.",
            how = listOf(
                "Crie 3 playlists: aquecimento, treino, relax.",
                "Associe cada playlist a um atalho/timer.",
                "Evite músicas com notificações/propagandas."
            )
        ),
        DicaTechHealth(
            title = "Relatórios semanais de desempenho",
            why = "Ver tendências (volume, intensidade, passos) orienta decisões. Ajustes baseados em dados evitam platôs.",
            how = listOf(
                "No domingo, revise volume de treino, passos e sono.",
                "Defina 1–2 micro-objetivos para a semana seguinte.",
                "Registre aprendizados no app de notas."
            )
        ),
        DicaTechHealth(
            title = "Competição saudável com amigos",
            why = "Gamificação e apoio social aumentam adesão. Rankings e desafios criam motivação extra.",
            how = listOf(
                "Entre em desafios de passos ou treinos.",
                "Compartilhe conquistas semanalmente.",
                "Celebre metas batidas em grupo."
            )
        ),
        DicaTechHealth(
            title = "Backup e privacidade dos dados",
            why = "Seu histórico de saúde é valioso. Backups protegem contra perdas e bons controles de privacidade evitam exposição indesejada.",
            how = listOf(
                "Ative backup em nuvem criptografado.",
                "Revise permissões de apps conectados.",
                "Use autenticação em 2 fatores."
            )
        ),
        DicaTechHealth(
            title = "Tela noturna e higiene do sono",
            why = "Luz azul à noite atrasa o sono. Ajustar a tela ajuda a dormir melhor e a render mais no dia seguinte.",
            how = listOf(
                "Ative modo noturno/filtro de luz azul após 20h.",
                "Programe desligamento automático de notificações.",
                "Deixe o celular longe da cama."
            )
        ),
        DicaTechHealth(
            title = "Rotas seguras e iluminação ao ar livre",
            why = "Treinar com visibilidade e rotas conhecidas reduz riscos. A tecnologia ajuda a planejar e registrar rotas seguras.",
            how = listOf(
                "Mapeie rotas iluminadas no app de mapas.",
                "Salve um atalho ‘voltar pra casa’ no relógio.",
                "Use braçadeira/lanterna quando necessário."
            )
        ),
        DicaTechHealth(
            title = "Registro de humor e energia",
            why = "Humor/energia afetam performance e escolhas alimentares. Anotar esses dados enriquece a análise e previne recaídas.",
            how = listOf(
                "Ao fim do treino, registre humor (1–5) e energia (1–5).",
                "Correlacione com sono e volume semanal.",
                "Ajuste carga quando houver queda persistente."
            )
        ),
        DicaTechHealth(
            title = "Alertas de calendário para treinos-chave",
            why = "Marcar treinos como compromissos aumenta prioridade e reduz faltas.",
            how = listOf(
                "Bloqueie na agenda 3 treinos fixos/semana.",
                "Ative alerta 1h antes (preparo) e 10 min antes (ação).",
                "Use localização para lembrar de sair no horário."
            )
        ),
        DicaTechHealth(
            title = "Ciclo de periodização simples no app",
            why = "Alternar blocos (base, força, potência, deload) evita platô e sobrecarga. Periodização guia a evolução segura.",
            how = listOf(
                "Programe 3–4 semanas de carga crescente.",
                "Inclua 1 semana de deload (volume/70%).",
                "Marque início e fim de cada bloco no app."
            )
        ),
        DicaTechHealth(
            title = "Notas por exercício com pontos de técnica",
            why = "Registros qualitativos (pés, respiração, tempo sob tensão) aceleram aprendizado e reduzem erros.",
            how = listOf(
                "Crie um campo de ‘dica técnica’ por exercício.",
                "Anote 1 ajuste por sessão.",
                "Revise suas notas antes do próximo treino."
            )
        ),
        DicaTechHealth(
            title = "Alertas de recuperação (48–72h) por grupamento",
            why = "Musculatura precisa de tempo para supercompensar. Alertas evitam treinar o mesmo grupo cedo demais.",
            how = listOf(
                "Marque o grupamento treinado no app.",
                "Ative lembrete para a janela de melhor recuperação.",
                "Se ainda houver dor intensa, ajuste o plano."
            )
        ),
        DicaTechHealth(
            title = "Mapa de calor de treinos (heatmap)",
            why = "Visualizar dias/horários mais frequentes ajuda a identificar padrões e criar rotinas realistas.",
            how = listOf(
                "Gere um heatmap semanal/mensal.",
                "Escolha 2 horários ‘blindados’ de maior aderência.",
                "Evite marcar treinos em horários de baixa energia."
            )
        ),
        DicaTechHealth(
            title = "Check-in de mobilidade em 3 minutos",
            why = "Mobilidade limitada trava técnica e aumenta risco. Um mini-screening digital direciona aquecimento e correções.",
            how = listOf(
                "Crie um protocolo: agachar profundo, alcance dos pés, rotação torácica.",
                "Registre notas (OK/atenção).",
                "Ajuste o aquecimento conforme os achados."
            )
        ),
        DicaTechHealth(
            title = "Sincronize equipamentos da academia (quando possível)",
            why = "Máquinas conectadas registram séries e carga automaticamente, reduzindo erros e acelerando o treino.",
            how = listOf(
                "Verifique se sua academia tem equipamentos conectados.",
                "Emparelhe via QR/NFC quando disponível.",
                "Revise seu treino já com dados preenchidos."
            )
        ),
        DicaTechHealth(
            title = "Rotina de ‘desligar’ pós-treino",
            why = "Fechar o ciclo ajuda o corpo a sair do modo estresse e iniciar a recuperação: alongar, hidratar, respirar e planejar a próxima sessão.",
            how = listOf(
                "Programe um fluxo: 2 min de respiração + 3 min de alongamento.",
                "Anote 1 vitória do treino.",
                "Marque o horário do próximo."
            ),
            note = "Pequenos rituais consolidam hábitos fortes."
        )
    )
}
