local widget =  require ("widget")
local composer = require ("composer")
local web = require ("webServiceConnection")
local scene = composer.newScene()

local LabelNome
local LabelEmail
local LabelSenha
local LabelUsuario
local TxtNome
local TxtEmail
local TxtSenha
local ButtonCadastrar 
local botaoLocked

function scene:create(event)

	local grupoCena = self.view 

	display.setDefault("background", 0.3, 0.6, 1)
    
<<<<<<< HEAD

=======
<<<<<<< HEAD
    local titulo = display.newText({text="Formulário",x=display.contentWidth/2,y=display.contentHeight/2 - 230})
    titulo:setFillColor( 1,1,0 )
    titulo.isEditable = true
    titulo.size = 30
=======
>>>>>>> cf82cc93b2aba3aeeac47572a0553f4546943f5b
    local titulo = display.newText({text="Formulário de cadastro",x=display.contentWidth/2,y=display.contentHeight/2 - 230})
    titulo:setFillColor( 1,1,0 )
    titulo.isEditable = true
    titulo.size = 25
<<<<<<< HEAD
=======
>>>>>>> mavenWeb
>>>>>>> cf82cc93b2aba3aeeac47572a0553f4546943f5b
    grupoCena:insert(titulo)

	LabelNome = display.newText({text="Nome",x=display.contentWidth/2 + 5,y=display.contentHeight/2 - 200})
	LabelNome:setFillColor(0,1,0)
	grupoCena:insert(LabelNome)
	

	LabelEmail = display.newText({text="Email",x=display.contentWidth/2 + 5,y=display.contentHeight/2 - 150})	
	LabelEmail:setFillColor(0,1,0)
	grupoCena:insert(LabelEmail)

	LabelUsuario = display.newText({text="usuario",x=display.contentWidth/2 + 5,y=display.contentHeight/2 - 100})
	LabelUsuario:setFillColor(0,1,0)
	grupoCena:insert(LabelUsuario)

	LabelSenha = display.newText({text="Senha",x=display.contentWidth/2 + 5,y=display.contentHeight/2 - 50})
	LabelSenha:setFillColor(0,1,0)
	grupoCena:insert(LabelSenha)


	ButtonCadastrar =  widget.newButton( 
	
		{
	
		label="Cadastrar", 
<<<<<<< HEAD
=======
<<<<<<< HEAD
		x = display.contentWidth/2,
		y = display.contentHeight/2 + 35,
=======
>>>>>>> cf82cc93b2aba3aeeac47572a0553f4546943f5b
		x = display.contentWidth/2 + 26,
		y = display.contentHeight/2 + 25,
		width = 96,
		height = 40,
<<<<<<< HEAD
=======
>>>>>>> mavenWeb
>>>>>>> cf82cc93b2aba3aeeac47572a0553f4546943f5b
        shape = "roundedRect",
		onRelease = salvarUsuario
		}
	)

	grupoCena:insert(ButtonCadastrar)  

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> cf82cc93b2aba3aeeac47572a0553f4546943f5b
	ButtonVoltar =  widget.newButton( 
	
		{
	
		label="voltar", 
		x = display.contentWidth/2 - 52, 
		y = display.contentHeight/2 + 25,
		width = 55,
		height = 40,
        shape = "roundedRect",
		onRelease = voltarTela
		}
	)

	grupoCena:insert(ButtonVoltar)  

<<<<<<< HEAD
=======
>>>>>>> mavenWeb
>>>>>>> cf82cc93b2aba3aeeac47572a0553f4546943f5b
	botaoLocked = widget.newButton( -- mostra e oculta a senha
        {
            width = 20,
            height = 20,
            x = display.contentWidth/2 + 115,
            y = display.contentHeight/2 - 29,
            defaultFile = "cadeado.png",
            onEvent = mostrarSenha
        }
    )
    grupoCena:insert(botaoLocked)
end

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> cf82cc93b2aba3aeeac47572a0553f4546943f5b
function voltarTela(event)
	
	if event.phase == "ended" then
		TxtNome.text = ""
		TxtEmail.text = ""
		txtUsuario.text = ""
		TxtSenha.text = ""
		composer.gotoScene("Login")
	end
end

<<<<<<< HEAD
=======
>>>>>>> mavenWeb
>>>>>>> cf82cc93b2aba3aeeac47572a0553f4546943f5b
function ValidateSave(response) -- validar salvamento

	if response == 200 then
		TxtNome.text = ""
		TxtEmail.text = ""
		TxtSenha.text = ""
		txtUsuario.text = ""
<<<<<<< HEAD
		alert = native.showAlert("Informacao","Usuario cadastrado com sucesso!", {"ok"} )
=======
<<<<<<< HEAD
		alert = native.showAlert("informacao","usuario cadastrado com sucesso!", {"ok"} )
		composer.gotoScene("Login")
	elseif response == 302 then
		alert = native.showAlert("erro","nome de usuario ja existe", {"ok"} )
	else
		alert = native.showAlert("erro","não foi possivel se cadastrar, verifique a sua conexão com a internet. Se o problema persistir entre em contato conosco em suporte.divulgueaqui@gmail.com", {"ok"} )
	end
end



=======
		alert = native.showAlert("Informacao","usuario cadastrado com sucesso!", {"ok"} )
>>>>>>> cf82cc93b2aba3aeeac47572a0553f4546943f5b
		composer.gotoScene("Login")
	elseif response == 302 then
		alert = native.showAlert("Erro","Nome de usuario ja existe", {"ok"} )
	else
		alert = native.showAlert("Erro","Não foi possivel se cadastrar, verifique a sua conexão com a internet. Se o problema persistir entre em contato conosco em suporte.divulgueaqui@gmail.com", {"ok"} )
	end
end

<<<<<<< HEAD
=======
>>>>>>> mavenWeb
>>>>>>> cf82cc93b2aba3aeeac47572a0553f4546943f5b
function salvarUsuario(event)
	--print("entrou no botao salvar")
	if event.phase == "ended" then
		local email = TxtEmail.text

		if  TxtNome.text ~= "" and TxtEmail.text ~= "" and  TxtSenha.text ~= "" and txtUsuario.text ~= "" then

			if TxtNome.text ~= " " and TxtNome.text ~= "  " and TxtNome.text ~= "   " and TxtNome.text ~= "    " and TxtNome.text ~= "     " and TxtNome.text ~= "      " then 

				if TxtSenha.text ~= " " and TxtSenha.text ~= "  " and TxtSenha.text ~= "   " and TxtSenha.text ~= "    " and TxtSenha.text ~= "     " and TxtSenha.text ~= "      " then

					if txtUsuario.text ~= " " and txtUsuario.text ~= "  " and txtUsuario.text ~= "   " and txtUsuario.text ~= "    " and txtUsuario.text ~= "     " and txtUsuario.text ~= "      " then

						if ( email:match("[A-Za-z0-9%.%%%+%-]+@[A-Za-z0-9%.%%%+%-]+%.%w%w%w?%w?") ) then
							
							if TxtNome.text ~= "" then -- aqui esta repetitivo pois antes estava fazendo a 

								if TxtSenha.text ~= "" then

									if txtUsuario.text ~= "" then

										 web:RegisterUserWS(TxtNome.text, TxtEmail.text, TxtSenha.text, txtUsuario.text)
										
									else
										alert = native.showAlert("Não foi possível cadastrar","Nome de usuario invalido", {"ok"} )
									end
								else
									alert = native.showAlert("Não foi possível cadastrar","Senha invalido", {"ok"} )
								end
							else
								alert = native.showAlert("Não foi possível cadastrar","Nome invalido", {"ok"} )
							end
						else
						   alert = native.showAlert("Não foi possível cadastrar","Email invalido", {"ok"} )
						end
					else
						alert = native.showAlert("Não foi possível cadastrar","Caracteres do usuario invalidos", {"ok"} )
					end
				else
					alert = native.showAlert("Não foi possível cadastrar","Caracteres do senha invalidos", {"ok"} )
				end
			else
				alert = native.showAlert("Não foi possível cadastrar","Caracteres do nome invalidos", {"ok"} )
			end
		else
			alert = native.showAlert("Não foi possível cadastrar","Todos os campos são obrigatorios", {"ok"} )
		end
	end
end

function mostrarSenha( event ) -- mostra a senha do usuario
    if event.phase == "began" then
<<<<<<< HEAD
        TxtSenha.isSecure = false
        tempo = timer.performWithDelay(1500,ocultarSenha)
=======
<<<<<<< HEAD
    --[[    if TxtSenha ~="" then
            if TxtSenha.isSecure == false then
                TxtSenha.isSecure = true
            else
                TxtSenha.isSecure = false
           end
        end]]
=======
>>>>>>> mavenWeb
            TxtSenha.isSecure = false
            tempo = timer.performWithDelay(1500,ocultarSenha)
>>>>>>> cf82cc93b2aba3aeeac47572a0553f4546943f5b
    end
end

function ocultarSenha() -- oculta a senha do usuario
	TxtSenha.isSecure = true
	timer.pause( tempo )
end

function scene:show(event)
	if event.phase == "did" then
		TxtNome = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 178, 200, 25 ) 
		TxtEmail = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 128, 200, 25 ) 
		txtUsuario = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 78, 200, 25 )
		TxtSenha = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 28, 200, 25 )
		TxtSenha.isSecure = true
	end
end

function scene:hide(event)
	display.remove(TxtNome)
	display.remove(TxtEmail)
	display.remove(txtUsuario)
	display.remove(TxtSenha)
end

function scene:destroy(event)
end

scene:addEventListener( "create", scene ) 
scene:addEventListener( "show", scene )  
scene:addEventListener( "hide", scene ) 
scene:addEventListener( "destroy", scene )

return scene


