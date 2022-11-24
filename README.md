# Desafio Técnico - Zoo Animal

Este desafio tem como objetivo construir um aplicativo que exiba uma lista de animais disponibilizada pela [zoo-animal](https://zoo-animal-api.herokuapp.com/).

Seu trabalho é construir o fluxo de telas seguindo com todas as conformidades desenhadas no [Figma](https://www.figma.com/file/qfhpUsU2epDAc9QgIJq9tc/Playground---Animals?node-id=201%3A595)

## Chamada de serviço

O serviço já está implementado. Para recuperar uma lista de animais basta chamar `getAnimals()` da classe `AnimalsRepository`. Será retornado uma lista com as seguintes informações:

json
{
"name": "Siamang",
"latin_name": "Hylobates syndactylus",
"animal_type": "Mammal",
"active_time": "Diurnal",
"length_min": "1.90",
"length_max": "2.00",
"weight_min": "20",
"weight_max": "23",
"lifespan": "23",
"habitat": "Tropical rainforest",
"diet": "Primarily fruit and leaves, some invertebrates",
"geo_range": "Malaysia and Sumatra",
"image_link": "https://upload.wikimedia.org/wikipedia/commons/a/a4/DPPP_5348.jpg",
"id": 162
}


## Requerimentos

* Usar o Coil para formatar a imagem;
* A lista de animais deverá ser feita em uma RecyclerView;
* Tanto a tela lista de animais quanto detalhes do animal deverão ser feitas como Activities;
* Deverá ser mostrado os estados de loading, erro e sucesso ao chamar o serviço;
* Ao clicar em um item da lista, deverá ser direcionado para tela de detalhes do animal, exibindo as informações do animal;
* Deverá ser utilizado a arquitetura MVVM;
* Deverá ser implementado os testes unitários para o ViewModel.

## Materiais de apoio

* Manipulação de imagem com [Coil](https://github.com/coil-kt/coil);
* Como implementar [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=pt-br).