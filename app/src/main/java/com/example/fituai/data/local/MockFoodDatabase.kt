package com.example.fituai.data.local

import com.example.fituai.domain.model.FoodItem

object MockFoodDatabase {

    val foods = listOf(

        // --- Itens de uso mais frequente ---
        FoodItem("Omelete com mussarela", 250, carbs = 1, protein = 20, fat = 20),
        FoodItem("Hambúrguer caseiro no pão francês", 560, carbs = 45, protein = 30, fat = 25),
        FoodItem("Coca-Cola Zero 1 copo", 1, carbs = 0, protein = 0, fat = 0),
        FoodItem("Café sem açúcar 1 xícara", 2, carbs = 0, protein = 0, fat = 0),
        FoodItem("Vitamina de banana 1 copo", 120, carbs = 22, protein = 4, fat = 2),
        FoodItem("Tapioca com queijo minas", 190, carbs = 27, protein = 6, fat = 4),

        // --- Bases do dia a dia ---
        FoodItem("Arroz branco 1/2 xícara cozido", 130, carbs = 28, protein = 2, fat = 0),
        FoodItem("Arroz integral 1/2 xícara cozido", 110, carbs = 23, protein = 2, fat = 1),
        FoodItem("Arroz parboilizado 1/2 xícara cozido", 120, carbs = 26, protein = 2, fat = 0),
        FoodItem("Feijão carioca 1/2 xícara cozido", 110, carbs = 19, protein = 7, fat = 1),
        FoodItem("Feijão preto 1/2 xícara cozido", 110, carbs = 20, protein = 7, fat = 1),
        FoodItem("Feijão vermelho 1/2 xícara cozido", 115, carbs = 20, protein = 7, fat = 1),
        FoodItem("Macarrão 1 xícara cozido", 200, carbs = 42, protein = 7, fat = 1),
        FoodItem("Farofa 2 colheres de sopa", 110, carbs = 16, protein = 1, fat = 4),
        FoodItem("Mandioca cozida 1/2 xícara", 160, carbs = 39, protein = 1, fat = 0),
        FoodItem("Purê de batata 1/2 xícara", 110, carbs = 18, protein = 2, fat = 4),
        FoodItem("Polenta cozida 1/2 xícara", 80, carbs = 17, protein = 2, fat = 0),
        FoodItem("Tapioca de goma 2 colheres de sopa", 106, carbs = 26, protein = 0, fat = 0),
        FoodItem("Tapioca de flocão de milho hidratado 1 unidade média", 130, carbs = 31, protein = 2, fat = 0),
        FoodItem("Abóbora cabotiá cozida 1/2 xícara", 45, carbs = 10, protein = 1, fat = 0),
        FoodItem("Quiabo refogado 1/2 xícara", 60, carbs = 7, protein = 2, fat = 3),
        FoodItem("Couve-flor cozida 1/2 xícara", 20, carbs = 4, protein = 2, fat = 0),
        FoodItem("Cuscuz nordestino 1/2 xícara cozido", 110, carbs = 24, protein = 3, fat = 0),

        // --- Receitas ---
        FoodItem("Bolo de banana com aveia 1 fatia", 201, carbs = 19, protein = 5, fat = 12),
        FoodItem("Brusqueta 1 pão francês molho tomate bacon 1 colher mussarela 1 fatia", 265, carbs = 29, protein = 12, fat = 12),

        // --- Feijoada e acompanhamentos ---
        FoodItem("Feijoada magra 1/2 xícara", 150, carbs = 13, protein = 11, fat = 5),
        FoodItem("Feijoada gorda 1/2 xícara", 220, carbs = 14, protein = 12, fat = 14),
        FoodItem("Couve refogada 1/2 xícara", 70, carbs = 7, protein = 2, fat = 4),
        FoodItem("Farofa pronta 2 colheres de sopa", 110, carbs = 16, protein = 1, fat = 4),
        FoodItem("Laranja em fatias 1/2 unidade", 30, carbs = 8, protein = 0, fat = 0),
        FoodItem("Torresmo 1 colher de sopa", 90, carbs = 0, protein = 2, fat = 9),
        FoodItem("Vinagrete 2 colheres de sopa", 15, carbs = 3, protein = 0, fat = 0),
        FoodItem("Banana frita air fryer 1/2 unidade média", 60, carbs = 15, protein = 0, fat = 0),
        FoodItem("Mandioca frita air fryer 1/2 xícara", 120, carbs = 29, protein = 1, fat = 1),

        // --- Proteínas ---
        FoodItem("Frango grelhado em cubos 1/2 xícara", 140, carbs = 0, protein = 27, fat = 3),
        FoodItem("Peito de frango cozido desfiado 1/2 xícara", 120, carbs = 0, protein = 24, fat = 2),
        FoodItem("Carne bovina em cubos grelhada 1/2 xícara", 160, carbs = 0, protein = 24, fat = 6),
        FoodItem("Carne bovina moída refogada 1/2 xícara", 170, carbs = 0, protein = 20, fat = 9),
        FoodItem("Bife de boi grelhado 1/2 xícara em tiras", 150, carbs = 0, protein = 24, fat = 6),
        FoodItem("Ovo cozido 1 unidade", 78, carbs = 0, protein = 6, fat = 5),
        FoodItem("Omelete 2 ovos", 180, carbs = 1, protein = 13, fat = 14),
        FoodItem("Atum em lata em água 1/2 xícara escorrido", 145, carbs = 0, protein = 32, fat = 1),
        FoodItem("Sardinha em lata em óleo 1/2 xícara", 210, carbs = 0, protein = 20, fat = 14),
        FoodItem("Linguiça calabresa em rodelas 1/2 xícara", 300, carbs = 2, protein = 14, fat = 26),
        FoodItem("Salsicha 1 unidade", 150, carbs = 2, protein = 6, fat = 13),
        FoodItem("Hambúrguer caseiro de patinho air fryer 1 unidade", 195, carbs = 0, protein = 26, fat = 10),
        FoodItem("Peito de frango air fryer 1/2 xícara em cubos", 115, carbs = 0, protein = 22, fat = 3),
        FoodItem("Tilápia air fryer 1/2 xícara em filé", 110, carbs = 0, protein = 23, fat = 2),
        FoodItem("Coxinha da asa de frango air fryer 2 unidades", 220, carbs = 0, protein = 18, fat = 15),

        // --- Pães e massas ---
        FoodItem("Pão francês 1 unidade", 135, carbs = 27, protein = 4, fat = 2),
        FoodItem("Pão de hambúrguer 1 unidade", 120, carbs = 22, protein = 4, fat = 2),
        FoodItem("Pão de forma integral 1 fatia", 70, carbs = 12, protein = 3, fat = 1),
        FoodItem("Pão sírio 1 unidade", 170, carbs = 35, protein = 6, fat = 1),
        FoodItem("Tortilha de trigo 1 unidade", 120, carbs = 20, protein = 4, fat = 3),
        FoodItem("Pão de queijo 1 unidade média", 80, carbs = 9, protein = 2, fat = 4),

        // --- Frios e queijos ---
        FoodItem("Peperoni frito air fryer 5 fatias", 130, carbs = 0, protein = 6, fat = 12),
        FoodItem("Presunto 2 fatias", 60, carbs = 1, protein = 8, fat = 3),
        FoodItem("Muçarela 1 fatia", 70, carbs = 1, protein = 5, fat = 5),
        FoodItem("Peito de peru 2 fatias", 60, carbs = 1, protein = 10, fat = 2),
        FoodItem("Queijo prato 1 fatia", 95, carbs = 1, protein = 6, fat = 8),
        FoodItem("Queijo minas frescal 1 fatia", 70, carbs = 1, protein = 5, fat = 5),
        FoodItem("Queijo cheddar 1 fatia", 80, carbs = 1, protein = 5, fat = 7),
        FoodItem("Queijo cottage 1/2 xícara", 110, carbs = 3, protein = 13, fat = 5),
        FoodItem("Requeijão cremoso 1 colher de sopa", 70, carbs = 1, protein = 2, fat = 6),

        // --- Verduras e legumes ---
        FoodItem("Alface 1 xícara", 8, carbs = 1, protein = 1, fat = 0),
        FoodItem("Tomate 1 unidade", 20, carbs = 4, protein = 1, fat = 0),
        FoodItem("Cenoura cozida 1/2 xícara", 45, carbs = 10, protein = 1, fat = 0),
        FoodItem("Abobrinha cozida 1/2 xícara", 18, carbs = 3, protein = 1, fat = 0),
        FoodItem("Brócolis cozido 1/2 xícara", 25, carbs = 4, protein = 2, fat = 0),
        FoodItem("Batata doce cozida 1/2 xícara", 90, carbs = 21, protein = 1, fat = 0),
        FoodItem("Beterraba cozida 1/2 xícara", 40, carbs = 9, protein = 2, fat = 0),
        FoodItem("Batata frita air fryer 1/2 xícara", 110, carbs = 24, protein = 2, fat = 2),

        // --- Frutas ---
        FoodItem("Banana prata 1 unidade", 89, carbs = 23, protein = 1, fat = 0),
        FoodItem("Maçã 1 unidade média", 80, carbs = 21, protein = 0, fat = 0),
        FoodItem("Mamão papaia 1 fatia", 45, carbs = 11, protein = 0, fat = 0),
        FoodItem("Laranja 1 unidade", 62, carbs = 15, protein = 1, fat = 0),
        FoodItem("Uva 1/2 xícara", 55, carbs = 14, protein = 0, fat = 0),
        FoodItem("Pera 1 unidade", 100, carbs = 26, protein = 1, fat = 0),
        FoodItem("Manga 1 fatia grande", 65, carbs = 16, protein = 1, fat = 0),
        FoodItem("Melancia 1 fatia média", 46, carbs = 11, protein = 1, fat = 0),
        FoodItem("Abacaxi 1 fatia", 50, carbs = 13, protein = 0, fat = 0),
        FoodItem("Kiwi 1 unidade", 42, carbs = 10, protein = 1, fat = 0),
        FoodItem("Tangerina 1 unidade", 53, carbs = 13, protein = 1, fat = 0),
        FoodItem("Goiaba 1 unidade", 68, carbs = 14, protein = 2, fat = 1),
        FoodItem("Abacate 1/2 xícara picado", 120, carbs = 6, protein = 1, fat = 11),
        FoodItem("Morango 1 xícara", 50, carbs = 11, protein = 1, fat = 0),

        // --- Condimentos e gorduras ---
        FoodItem("Maionese 1 colher de sopa", 90, carbs = 0, protein = 0, fat = 10),
        FoodItem("Ketchup 1 colher de sopa", 20, carbs = 5, protein = 0, fat = 0),
        FoodItem("Mostarda 1 colher de sopa", 10, carbs = 1, protein = 0, fat = 1),
        FoodItem("Manteiga 1 colher de chá", 36, carbs = 0, protein = 0, fat = 4),
        FoodItem("Azeite de oliva 1 colher de chá", 40, carbs = 0, protein = 0, fat = 4),
        FoodItem("Bacon frito 1 colher de sopa", 55, carbs = 0, protein = 3, fat = 5),
        FoodItem("Leite em pó integral 1 colher de sopa", 55, carbs = 4, protein = 3, fat = 3),

        // --- Laticínios e derivados ---
        FoodItem("Iogurte natural integral 1 copo 170g", 150, carbs = 12, protein = 8, fat = 4),
        FoodItem("Iogurte grego tradicional 1 pote 100g", 120, carbs = 9, protein = 10, fat = 4),
        FoodItem("Danoninho 1 potinho 45g", 45, carbs = 6, protein = 1, fat = 1),
        FoodItem("Yakult 1 garrafinha 65ml", 50, carbs = 12, protein = 1, fat = 0),

        // --- Bebidas ---
        FoodItem("Leite integral 1 copo 200ml", 120, carbs = 9, protein = 6, fat = 6),
        FoodItem("Leite desnatado 1 copo 200ml", 83, carbs = 12, protein = 8, fat = 0),
        FoodItem("Suco de laranja natural 1 copo", 110, carbs = 25, protein = 2, fat = 0),
        FoodItem("Refrigerante 1 copo", 140, carbs = 35, protein = 0, fat = 0),
        FoodItem("Guaraná 1 copo", 140, carbs = 35, protein = 0, fat = 0),
        FoodItem("Chá mate 1 copo", 0, carbs = 0, protein = 0, fat = 0),
        FoodItem("Red Bull lata 250 ml", 110, carbs = 27, protein = 0, fat = 0),
        FoodItem("Red Bull sem açúcar lata 250 ml", 10, carbs = 2, protein = 0, fat = 0),
        FoodItem("Monster lata 473 ml", 210, carbs = 54, protein = 0, fat = 0),
        FoodItem("Monster sem açúcar lata 473 ml", 15, carbs = 4, protein = 0, fat = 0),
        FoodItem("Isotônico Gatorade 1 garrafa 500ml", 120, carbs = 30, protein = 0, fat = 0),
        FoodItem("Isotônico Powerade 1 garrafa 500ml", 120, carbs = 31, protein = 0, fat = 0),
        FoodItem("Água com gás 1 copo 200ml", 0, carbs = 0, protein = 0, fat = 0),
        FoodItem("Água mineral 1 copo 200ml", 0, carbs = 0, protein = 0, fat = 0),
        FoodItem("Café sem açúcar cápsula Nespresso 1 unidade", 2, carbs = 0, protein = 0, fat = 0),

        // --- Sobremesas e fast foods ---
        FoodItem("Bolo de chocolate 1 fatia", 250, carbs = 35, protein = 3, fat = 12),
        FoodItem("Brigadeiro 1 unidade", 100, carbs = 16, protein = 1, fat = 4),
        FoodItem("Pizza Hut superfatia de pepperoni 1 fatia", 330, carbs = 34, protein = 14, fat = 16),
        FoodItem("Sorvete do Jeronimo casquinha com copinho 1 unidade", 170, carbs = 27, protein = 4, fat = 5)
    )
}
