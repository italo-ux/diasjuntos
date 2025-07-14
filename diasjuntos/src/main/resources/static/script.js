// Faz uma requisição para a API que retorna o número do dia
fetch('/api/numero')
  .then(response => {
    // Verifica se a resposta da API foi bem-sucedida (status 200-299)
    if (!response.ok) {
      // Se não for, lança um erro que será tratado no catch
      throw new Error('Erro na resposta da API');
    }
    // Se tudo certo, converte o corpo da resposta para JSON
    return response.json();
  })
  .then(numero => {
    // Adiciona log para depuração
    console.log('Resposta da API:', numero);
    // Se o JSON for um objeto, pega a propriedade 'numero'
    const valor = typeof numero === 'object' && numero !== null ? numero.numero : numero;
    document.getElementById('numero').textContent = valor;
  })
  .catch(error => {
    // Caso ocorra algum erro (na requisição ou na resposta), entra aqui
    console.error('Erro ao buscar número:', error);
    // Atualiza o texto para avisar o usuário que houve um problema
    document.getElementById('numero').textContent = 'Erro ao carregar número';
  });
