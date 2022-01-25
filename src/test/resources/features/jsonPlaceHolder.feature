#language: pt
  #Author: Jardeson Santos
  #Encoding: UTF-8

  @regressivo
  Funcionalidade: Criar e editar postagens JsonPlaceHolder

    @post
    Cenario: Criar uma postagem POST na API JsonPlaceHolder
      Dado que tenho um token valido
      Quando realizo uma request de postagem com dados validos
      Entao a postagem deve ser publicada
      E o status code deve ser 201

      @get
      Cenario: Buscar uma postagem GET na API JsonPlaceHolder
        Dado que tenho um token valido
        E possuo uma postagem na API JsonPlaceHolder
        Quando realizo uma request de buscar postagem
        Entao a postagem deve ser retornada
        E o status code deve ser 200

        @put
        Cenario: Alterar uma postagem PUT na API JsonPlaceHolder
          Dado que tenho um token valido
          E possuo uma postagem na API JsonPlaceHolder
          Quando altero os dados da postagem
          Entao a postagem deve ser alterada com sucesso
          E o status code deve ser 200

          @patch
          Cenario: Alterar postagem PATCH na API JsonPlaceHolder
            Dado que tenho um token valido
            E possuo uma postagem na API JsonPlaceHolder
            Quando altero um ou mais dados do usuario
            Entao a postagem deve ser alterada com sucesso
            E o status code deve ser 200

            @delete
            Cenario: Deletar uma postagem DELETE na API JsonPlaceHolder
              Dado que tenho um token valido
              E possuo uma postagem na API JsonPlaceHolder
              Quando deletar uma postagem
              Entao a postagem deve ser removida com sucesso
              E o status code deve ser 200