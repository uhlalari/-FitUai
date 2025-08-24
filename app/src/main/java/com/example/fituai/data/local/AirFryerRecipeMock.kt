package com.example.fituai.data.local

data class Receita(
    val name: String,
    val category: String,
    val ingredients: List<String>,
    val preparationSteps: List<String>,
    val preparationTimeMinutes: Int,
    val servings: Int,
    val caloriesPerServing: Int
)

object MockRecipeDatabase {

    val receitas = listOf(
        Receita(
            "Frango com Batata Doce", "Almoço",
            listOf(
                "150g de peito de frango em cubos",
                "1 batata doce média",
                "1 colher de chá de azeite",
                "Sal, pimenta e páprica"
            ),
            listOf("Tempere o frango e a batata.", "Coloque na Air Fryer por 20 minutos a 200°C."),
            20, 1, 350
        ),
        Receita(
            "Banana com Canela", "Doce",
            listOf("1 banana prata", "Canela em pó"),
            listOf("Corte a banana e polvilhe canela.", "Asse por 8 minutos a 180°C."),
            8, 1, 90
        ),
        Receita(
            "Pão de Alho Fit", "Lanche",
            listOf(
                "1 pão integral",
                "1 colher de sopa de requeijão light",
                "1 dente de alho",
                "Orégano"
            ),
            listOf(
                "Misture requeijão, alho e orégano.",
                "Espalhe no pão e asse por 5 minutos a 200°C."
            ),
            5, 1, 130
        ),
        Receita(
            "Legumes Assados", "Janta",
            listOf("Cenoura, abobrinha e brócolis", "1 colher de chá de azeite", "Ervas a gosto"),
            listOf("Misture tudo e asse na Air Fryer por 15 minutos a 200°C."),
            15, 1, 120
        ),
        Receita(
            "Chips de Batata Doce", "Lanche",
            listOf("1 batata doce fatiada fina", "1 colher de chá de azeite", "Sal"),
            listOf("Misture tudo.", "Asse 12 minutos a 180°C, virando na metade."),
            12, 1, 100
        ),
        Receita(
            "Tilápia Temperada", "Janta",
            listOf("1 filé de tilápia", "1 colher de chá de azeite", "Limão, sal, pimenta"),
            listOf("Tempere e asse na Air Fryer por 15 minutos a 180°C."),
            15, 1, 200
        ),
        Receita(
            "Maçã Assada com Aveia", "Doce",
            listOf("1 maçã", "1 colher de sopa de aveia", "Canela", "Mel (opcional)"),
            listOf("Corte a maçã, recheie com aveia e canela.", "Asse por 12 minutos a 180°C."),
            12, 1, 110
        ),
        Receita(
            "Omelete de Forno", "Lanche",
            listOf("2 ovos", "Legumes picados", "Sal e pimenta"),
            listOf(
                "Bata os ovos e misture os legumes.",
                "Despeje em uma forma e asse 10 minutos a 200°C."
            ),
            10, 1, 180
        ),
        Receita(
            "Bolinho de Aveia", "Doce",
            listOf("2 colheres de aveia", "1 banana amassada", "1 ovo"),
            listOf("Misture tudo.", "Coloque em forminhas e asse 10 minutos a 180°C."),
            10, 2, 95
        ),
        Receita(
            "Quibe de Forno", "Almoço",
            listOf("150g de carne moída", "1/2 xícara de trigo para quibe", "Hortelã, cebola, sal"),
            listOf("Misture tudo e modele.", "Asse por 18 minutos a 200°C."),
            18, 2, 240
        ),
        Receita(
            "Berinjela à Parmegiana", "Janta",
            listOf("Fatias de berinjela", "Molho de tomate", "Queijo light"),
            listOf("Monte as camadas e asse 15 minutos a 180°C."),
            15, 1, 150
        ),
        Receita(
            "Tomate Recheado", "Janta",
            listOf("1 tomate grande", "Atum ou frango desfiado", "Requeijão light"),
            listOf("Recheie o tomate.", "Asse 12 minutos a 200°C."),
            12, 1, 130
        ),
        Receita(
            "Torrada de Ovo", "Lanche",
            listOf("1 fatia de pão integral", "1 ovo", "Sal, pimenta"),
            listOf("Corte o centro do pão e adicione o ovo.", "Asse 6 minutos a 200°C."),
            6, 1, 150
        ),
        Receita(
            "Hambúrguer Caseiro Fit", "Almoço",
            listOf("120g de carne magra", "Temperos a gosto"),
            listOf("Modele e asse 12 minutos na Air Fryer."),
            12, 1, 280
        ),
        Receita(
            "Tofu Crocante", "Lanche",
            listOf("100g de tofu", "Shoyu light", "Gergelim"),
            listOf("Tempere e asse por 15 minutos a 200°C."),
            15, 1, 140
        ),
        Receita(
            "Mandioca na Air Fryer", "Janta",
            listOf("150g de mandioca cozida", "1 colher de chá de azeite", "Sal"),
            listOf("Asse por 12 minutos a 200°C."),
            12, 1, 210
        ),
        Receita(
            "Bolo de Banana Fit", "Doce",
            listOf("1 banana", "1 ovo", "2 colheres de aveia", "Canela"),
            listOf("Misture e coloque em forminhas.", "Asse por 10 minutos a 180°C."),
            10, 2, 120
        ),
        Receita(
            "Peito de Frango Empanado com Aveia", "Almoço",
            listOf("Peito de frango", "Ovo", "Aveia em flocos", "Temperos"),
            listOf("Empane e asse 15 minutos a 200°C."),
            15, 1, 310
        ),
        Receita(
            "Couve Crocante", "Janta",
            listOf("Folhas de couve", "Azeite", "Sal"),
            listOf("Asse por 6 minutos a 180°C até dourar."),
            6, 1, 60
        ),
        Receita(
            "Cookies de Banana", "Doce",
            listOf("1 banana", "2 colheres de aveia", "Canela"),
            listOf("Misture e modele os cookies.", "Asse 10 minutos a 180°C."),
            10, 2, 80
        ),
        Receita(
            "Espetinho de Frango", "Almoço",
            listOf("Cubos de frango", "Cebola e pimentão", "Temperos"),
            listOf("Monte os espetinhos e asse 12 minutos a 200°C."),
            12, 2, 220
        ),
        Receita(
            "Mini Pizza de Tapioca", "Lanche",
            listOf("3 colheres de goma de tapioca", "Molho de tomate", "Queijo light"),
            listOf("Coloque na Air Fryer por 6 minutos a 200°C."),
            6, 1, 140
        ),
        Receita(
            "Batata Rústica", "Janta",
            listOf("1 batata média com casca", "Ervas, azeite e sal"),
            listOf("Corte e asse por 18 minutos a 200°C."),
            18, 1, 190
        ),
        Receita(
            "Panqueca de Aveia", "Lanche",
            listOf("1 ovo", "2 colheres de aveia", "1 colher de iogurte natural"),
            listOf("Misture e asse por 10 minutos em forma pequena."),
            10, 1, 130
        ),
        Receita(
            "Muffin de Ovo e Espinafre", "Lanche",
            listOf("2 ovos", "Espinafre picado", "Queijo branco", "Sal"),
            listOf("Misture e asse em forminhas 10 minutos a 180°C."),
            10, 2, 100
        ),
        Receita(
            "Doce de Abóbora Light", "Doce",
            listOf("Abóbora em cubos", "Adoçante culinário", "Cravo e canela"),
            listOf("Asse 20 minutos a 180°C mexendo 2 vezes."),
            20, 2, 90
        ),
        Receita(
            "Coxinha de Frango Fit", "Lanche",
            listOf("Purê de batata doce", "Frango desfiado", "Temperos"),
            listOf("Modele e asse por 15 minutos a 200°C."),
            15, 2, 140
        ),
        Receita(
            "Tilápia com Legumes", "Almoço",
            listOf("1 filé de tilápia", "Brócolis e cenoura", "Temperos"),
            listOf("Coloque tudo na Air Fryer por 20 minutos a 200°C."),
            20, 1, 280
        ),
        Receita(
            "Brownie de Banana", "Doce",
            listOf("1 banana", "1 colher de cacau", "1 ovo", "Aveia"),
            listOf("Misture e asse por 12 minutos a 180°C."),
            12, 2, 110
        ),
        Receita(
            "Abobrinha Recheada", "Janta",
            listOf("Abobrinha cortada", "Frango ou carne moída", "Requeijão light"),
            listOf("Recheie e asse 15 minutos a 180°C."),
            15, 2, 160
        )
    )
}
