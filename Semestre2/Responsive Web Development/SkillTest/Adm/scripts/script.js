const plusHabilidade = document.querySelector("#add-habilidades");
const habilidades = document.querySelector(".habilidades")

const plusPerguntas = document.querySelector("#add-pergunta");
const perguntas = document.querySelector(".perguntas")

plusHabilidade.addEventListener('click', () => {

    let fieldset = document.createElement('fieldset');
    habilidades.appendChild(fieldset);

    let inputHabilidade = document.createElement('input');
    inputHabilidade.setAttribute("type", "text");
    inputHabilidade.setAttribute("placeholder", "Habilidade");

    let inputPeso = document.createElement('input');
    inputPeso.setAttribute("type", "number");
    inputPeso.setAttribute("placeholder", "Peso");

    fieldset.appendChild(inputHabilidade);
    fieldset.appendChild(inputPeso);
});

plusPerguntas.addEventListener('click', () => {
    let fieldset = document.createElement('fieldset');
    perguntas.appendChild(fieldset)

    let inputPergunta = document.createElement('input')
    inputPergunta.setAttribute("type", "text");
    inputPergunta.setAttribute("placeholder", "Pergunta");

    let inputPeso = document.createElement('input');
    inputPeso.setAttribute("type", "number");
    inputPeso.setAttribute("placeholder", "Peso");

    fieldset.appendChild(inputPergunta)
    fieldset.appendChild(inputPeso)
});


// Código desenvolvido pelo andrey para a aula de chatbot
var session_id = '';

const carregarDados = () => {
    const input = document.querySelector('#pergunta');

    if (input.value) criaLinha(input.value, 'me');

    const digitando = document.querySelector('span');
    digitando.classList.add('ativo');

    const mensagem = input.value ? input.value : '';
    input.value = '';

    fetch(
            `nodered-suporte.mybluemix.net/chat?mensagem=${mensagem}&session_id=${session_id}`
        )
        .then( resultado => resultado.json())
        .then( dados => {
            dados.respostas.forEach((resposta) => {
                if (resposta.text) criaLinha(resposta.text, 'bot');
            });
            session_id = dados.session_id;
            digitando.classList.remove('ativo');
        });
};

const criaLinha = (msg, tipo) => {
    const chat = document.querySelector('.conversa');
    const linha = document.createElement('div');
    const balao = criaBalaoConversa(msg, tipo);
    linha.classList.add('linha');
    linha.appendChild(balao);
    chat.appendChild(linha);
    scrollDivDown(chat);
};

const criaBalaoConversa = (texto, tipo) => {
    const balao = document.createElement('div');
    balao.classList.add('chat');
    balao.classList.add(tipo);
    balao.innerHTML = texto;
    return balao;
};

const scrollDivDown = div => {
    for (let i = 0; i < div.offsetHeight; i++) {
        div.scrollTop++;
    }
};

document
    .querySelector('#pergunta')
    .addEventListener('keypress', function (event) {
        if (event.keyCode === 13) {
            carregarDados();
        }
    });

window.onload = carregarDados();