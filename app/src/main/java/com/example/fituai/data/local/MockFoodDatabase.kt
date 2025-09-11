package com.example.fituai.data.local

import com.example.fituai.domain.model.FoodItem

object MockFoodDatabase {

    val foods = listOf(
        // --- Itens de uso mais frequente ---
        FoodItem("Omelete com mussarela (2 ovos + 1 fatia)", 250, carbs = 1, protein = 20, fat = 20),
        FoodItem("Hambúrguer no pão francês (com patinho, maionese, ketchup e mussarela)", 560, carbs = 45, protein = 30, fat = 25),
        FoodItem("Coca-Cola Zero (1 copo)", 1, carbs = 0, protein = 0, fat = 0),
        FoodItem("Café sem açúcar (1 xícara)", 2, carbs = 0, protein = 0, fat = 0),
        FoodItem("Vitamina de banana (1/2 banana + 1/2 copo de leite em pó diluído)", 120, carbs = 22, protein = 4, fat = 2),
        FoodItem("Tapioca com queijo minas (2 colheres de goma + 1 fatia de queijo)", 150, carbs = 16, protein = 5, fat = 4),
        FoodItem("Pão de queijo Seu Ninico (4 unid.)", 320, carbs = 36, protein = 6, fat = 16),

        // --- Bases do dia a dia (medidas padronizadas) ---
        FoodItem("Arroz branco (1/2 xícara cozido)", 130, carbs = 28, protein = 2, fat = 0),
        FoodItem("Arroz integral (1/2 xícara cozido)", 110, carbs = 23, protein = 2, fat = 1),
        FoodItem("Feijão carioca (1/2 xícara cozido)", 110, carbs = 19, protein = 7, fat = 1),
        FoodItem("Feijão preto (1/2 xícara cozido)", 110, carbs = 20, protein = 7, fat = 1),
        FoodItem("Macarrão cozido (1 xícara)", 200, carbs = 42, protein = 7, fat = 1),
        FoodItem("Farofa (2 colheres de sopa)", 110, carbs = 16, protein = 1, fat = 4),
        FoodItem("Mandioca/Aipim cozido (1/2 xícara)", 160, carbs = 39, protein = 1, fat = 0),
        FoodItem("Purê de batata (1/2 xícara)", 110, carbs = 18, protein = 2, fat = 4),
        FoodItem("Polenta cozida (1/2 xícara)", 80, carbs = 17, protein = 2, fat = 0),
        FoodItem("Tapioca (2 colheres de sopa de goma)", 70, carbs = 15, protein = 0, fat = 0),

        // --- Proteínas ---
        FoodItem("Frango grelhado em cubos (1/2 xícara)", 140, carbs = 0, protein = 27, fat = 3),
        FoodItem("Peito de frango cozido desfiado (1/2 xícara)", 120, carbs = 0, protein = 24, fat = 2),
        FoodItem("Carne bovina em cubos grelhada (1/2 xícara)", 180, carbs = 0, protein = 24, fat = 8),
        FoodItem("Carne bovina moída refogada (1/2 xícara)", 170, carbs = 0, protein = 20, fat = 9),
        FoodItem("Ovo cozido (1 unid.)", 78, carbs = 0, protein = 6, fat = 5),
        FoodItem("Omelete (2 ovos)", 180, carbs = 1, protein = 13, fat = 14),
        FoodItem("Atum em lata em água (1/2 xícara escorrido)", 145, carbs = 0, protein = 32, fat = 1),
        FoodItem("Sardinha em lata em óleo (1/2 xícara)", 210, carbs = 0, protein = 20, fat = 14),
        FoodItem("Linguiça calabresa em rodelas (1/2 xícara)", 300, carbs = 2, protein = 14, fat = 26),
        FoodItem("Salsicha (1 unid.)", 150, carbs = 2, protein = 6, fat = 13),
        FoodItem("Hambúrguer caseiro de patinho (air fryer, 1 unid.)", 195, carbs = 0, protein = 26, fat = 10),

        // --- Pães e massas ---
        FoodItem("Pão francês (1 unid.)", 135, carbs = 27, protein = 4, fat = 2),
        FoodItem("Pão de hambúrguer (1 unid.)", 120, carbs = 22, protein = 4, fat = 2),
        FoodItem("Pão de forma integral (1 fatia)", 70, carbs = 12, protein = 3, fat = 1),
        FoodItem("Pão sírio (1 unid.)", 170, carbs = 35, protein = 6, fat = 1),
        FoodItem("Tortilha/Wrap de trigo (1 unid.)", 120, carbs = 20, protein = 4, fat = 3),
        FoodItem("Pão de queijo (1 unid. média)", 80, carbs = 9, protein = 2, fat = 4),

        // --- Queijos e frios ---
        FoodItem("Muçarela (1 fatia)", 80, carbs = 1, protein = 7, fat = 6),
        FoodItem("Queijo minas (1 fatia)", 80, carbs = 1, protein = 6, fat = 6),
        FoodItem("Queijo prato (1 fatia)", 100, carbs = 1, protein = 6, fat = 8),
        FoodItem("Queijo cheddar (1 fatia)", 80, carbs = 1, protein = 5, fat = 7),
        FoodItem("Presunto (2 fatias)", 60, carbs = 1, protein = 8, fat = 3),
        FoodItem("Requeijão (1 colher de sopa)", 70, carbs = 1, protein = 2, fat = 6),

        // --- Verduras e legumes ---
        FoodItem("Alface (1 xícara)", 8, carbs = 1, protein = 1, fat = 0),
        FoodItem("Tomate (1 unid.)", 20, carbs = 4, protein = 1, fat = 0),
        FoodItem("Cenoura cozida (1/2 xícara)", 45, carbs = 10, protein = 1, fat = 0),
        FoodItem("Abobrinha cozida (1/2 xícara)", 18, carbs = 3, protein = 1, fat = 0),
        FoodItem("Brócolis cozido (1/2 xícara)", 25, carbs = 4, protein = 2, fat = 0),
        FoodItem("Couve refogada (1/2 xícara)", 70, carbs = 7, protein = 2, fat = 4),
        FoodItem("Batata doce cozida (1/2 xícara)", 90, carbs = 21, protein = 1, fat = 0),
        FoodItem("Beterraba cozida (1/2 xícara)", 40, carbs = 9, protein = 2, fat = 0),

        // --- Frutas ---
        FoodItem("Banana prata (1 unid.)", 89, carbs = 23, protein = 1, fat = 0),
        FoodItem("Maçã (1 unid. média)", 80, carbs = 21, protein = 0, fat = 0),
        FoodItem("Mamão papaia (1 fatia)", 45, carbs = 11, protein = 0, fat = 0),
        FoodItem("Laranja (1 unid.)", 62, carbs = 15, protein = 1, fat = 0),
        FoodItem("Uva (1/2 xícara)", 55, carbs = 14, protein = 0, fat = 0),
        FoodItem("Pera (1 unid.)", 100, carbs = 26, protein = 1, fat = 0),
        FoodItem("Manga (1 fatia grande)", 65, carbs = 16, protein = 1, fat = 0),
        FoodItem("Melancia (1 fatia média)", 46, carbs = 11, protein = 1, fat = 0),
        FoodItem("Abacaxi (1 fatia)", 50, carbs = 13, protein = 0, fat = 0),
        FoodItem("Kiwi (1 unid.)", 42, carbs = 10, protein = 1, fat = 0),
        FoodItem("Tangerina (1 unid.)", 53, carbs = 13, protein = 1, fat = 0),
        FoodItem("Goiaba (1 unid.)", 68, carbs = 14, protein = 2, fat = 1),
        FoodItem("Abacate (1/2 xícara picado)", 120, carbs = 6, protein = 1, fat = 11),
        FoodItem("Morango (1 xícara)", 50, carbs = 11, protein = 1, fat = 0),

        // --- Condimentos ---
        FoodItem("Maionese (1 colher de sopa)", 90, carbs = 0, protein = 0, fat = 10),
        FoodItem("Ketchup (1 colher de sopa)", 20, carbs = 5, protein = 0, fat = 0),
        FoodItem("Mostarda (1 colher de sopa)", 10, carbs = 1, protein = 0, fat = 1),
        FoodItem("Manteiga (1 colher de chá)", 36, carbs = 0, protein = 0, fat = 4),
        FoodItem("Azeite de oliva (1 colher de chá)", 40, carbs = 0, protein = 0, fat = 4),

        // --- Bebidas ---
        FoodItem("Leite integral (1 copo)", 120, carbs = 9, protein = 6, fat = 6),
        FoodItem("Leite desnatado (1 copo)", 83, carbs = 12, protein = 8, fat = 0),
        FoodItem("Iogurte natural (1 copo)", 150, carbs = 12, protein = 8, fat = 4),
        FoodItem("Iogurte grego (1 pote)", 120, carbs = 9, protein = 10, fat = 4),
        FoodItem("Suco de laranja natural (1 copo)", 110, carbs = 25, protein = 2, fat = 0),
        FoodItem("Refrigerante (1 copo)", 140, carbs = 35, protein = 0, fat = 0),
        FoodItem("Guaraná (1 copo)", 140, carbs = 35, protein = 0, fat = 0),
        FoodItem("Chá mate (1 copo)", 0, carbs = 0, protein = 0, fat = 0),
        FoodItem("Red Bull (lata 250ml)", 110, carbs = 27, protein = 0, fat = 0),
        FoodItem("Red Bull sem açúcar (lata 250ml)", 10, carbs = 2, protein = 0, fat = 0),
        FoodItem("Monster (lata 473ml)", 210, carbs = 54, protein = 0, fat = 0),
        FoodItem("Monster sem açúcar (lata 473ml)", 15, carbs = 4, protein = 0, fat = 0),

        // --- Sobremesas ---
        FoodItem("Bolo de chocolate (1 fatia)", 250, carbs = 35, protein = 3, fat = 12),
        FoodItem("Brigadeiro (1 unid.)", 100, carbs = 16, protein = 1, fat = 4),
        FoodItem("Mousse de maracujá (1/2 xícara)", 220, carbs = 30, protein = 3, fat = 12),
        FoodItem("Açaí (1 tigela pequena)", 250, carbs = 40, protein = 2, fat = 8),
        FoodItem("Chocolate ao leite (1 tabletinho)", 130, carbs = 15, protein = 2, fat = 8),

        // --- Extras de café da manhã / lanches ---
        FoodItem("Pão com manteiga (1 unid.)", 200, carbs = 28, protein = 4, fat = 8),
        FoodItem("Aveia em flocos (2 colheres de sopa)", 70, carbs = 12, protein = 3, fat = 2),
        FoodItem("Granola (1/2 xícara)", 200, carbs = 32, protein = 4, fat = 6),
        FoodItem("Whey protein (1 scoop, com água)", 120, carbs = 3, protein = 24, fat = 2)
    )
}
