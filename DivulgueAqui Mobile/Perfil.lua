local widget =  require ("widget")
local composer = require ("composer")
local scene = composer.newScene()
local web = require ("webServiceConnection")
local login = require ("Login")

local LabelNome
local LabelEmail
local LabelTelefone
local LabelSenha
local TxtNome
local TxtEmail
local TxtTelefone
local TxtSenhaNova
local sTxtSenhaAntiga
local ButtonSave 
local ButtonLogout
local botaoLocked

function scene:create(event)

	local grupoCena = self.view 


	display.setDefault("background", 0.3, 0.6, 1)

    -- Se achar melhor outro nome, fique a vontade!
	local titulo = display.newText({text = "Status Do Perfil",x=display.contentWidth/2,y=display.contentHeight/2 - 225 })
	titulo:setFillColor( 1,1,0 )
	titulo.isEditable = true
	titulo.size = 30
	grupoCena:insert(titulo)
	
	LabelNome = display.newText({text="Nome ",x=display.contentWidth/2,y=display.contentHeight/2 - 200})
	LabelNome:setFillColor( 0,1,0 )
	grupoCena:insert(LabelNome)
	

	LabelEmail = display.newText({text="Email ",x=display.contentWidth/2 ,y=display.contentHeight/2 - 148})	
	LabelEmail:setFillColor( 0,1,0 )
	grupoCena:insert(LabelEmail)

	LabelSenha = display.newText({text="Senha antiga ",x=display.contentWidth/2,y=display.contentHeight/2 - 97})
	LabelSenha:setFillColor( 0,1,0 )
	grupoCena:insert(LabelSenha)

	LabelSenha = display.newText({text="Nova senha ",x=display.contentWidth/2,y=display.contentHeight/2 - 47})
	LabelSenha:setFillColor( 0,1,0 )
	grupoCena:insert(LabelSenha)


	ButtonSave =  widget.newButton( 

		{
		label="Save",
		x = display.contentWidth/2,
		y = display.contentHeight/2 + 40,
		onRelease = updateUser,
        strokeWidth = 4,
        shape = "roundedRect" 
		
		}
	)
	grupoCena:insert(ButtonSave)

	botaoLocked2 = widget.newButton( -- mostra e oculta a senha
        {
            width = 20,
            height = 20,
            x = display.contentWidth/2 + 113,
            y = display.contentHeight/2 - 75,
            defaultFile = "cadeado.png",
            onEvent = mostrarSenha2
        }
    )
    grupoCena:insert(botaoLocked2)

    botaoLocked = widget.newButton( -- mostra e oculta a senha
        {
            width = 20,
            height = 20,
            x = display.contentWidth/2 + 113,
            y = display.contentHeight/2 - 22,
            defaultFile = "cadeado.png",
            onEvent = mostrarSenha
        }
    )
    grupoCena:insert(botaoLocked)
end

function confirmacaoDeAtualizacaoDoUsuario(codigo)
	
		if codigo == 200 then
			alert = native.showAlert("Informação","Usuario alterado com sucesso!", {"ok"} )
			nome = TxtNome.text
			emailUser = TxtEmail.text
			web:recoverPublicacaoIdWS(codigoUser)
			composer.gotoScene("Logado")
		else
			alert = native.showAlert("Erro","Não foi possível alterar o usuario. Se o problema persistir entre em contato conosco em suporte.divulgueaqui@gmail.com", {"ok"} )
		end
end

function updateUser(event)

	if event.phase == "ended" then
		local email =  TxtEmail.text

		if  TxtNome.text ~= "" and TxtEmail.text ~= "" and  TxtSenhaNova.text ~= "" and TxtSenhaAntiga.text ~= "" then
		
			if  TxtNome.text ~= "" and  TxtNome.text ~= " " and TxtNome.text ~= "  " and TxtNome.text ~= "   " and TxtNome.text ~= "    " and TxtNome.text ~= "     " and TxtNome.text ~= "      "  then

				if TxtSenhaAntiga.text ~= "" and TxtSenhaAntiga.text ~= " " and TxtSenhaAntiga.text ~= "  " and TxtSenhaAntiga.text ~= "    " and TxtSenhaAntiga.text ~= "     " then

					if TxtSenhaAntiga.text == senhaUser then

						if  ( email:match("[A-Za-z0-9%.%%%+%-]+@[A-Za-z0-9%.%%%+%-]+%.%w%w%w?%w?") ) then

							if TxtSenhaNova.text ~= "" and TxtSenhaNova.text ~= " " and TxtSenhaNova.text ~= "  " and TxtSenhaNova.text ~= "   " and TxtSenhaNova.text ~= "    " and TxtSenhaNova.text ~= "     " and TxtSenhaNova.text ~= "      " then
								
								web:updateUserWS(codigoUser, TxtNome.text, TxtEmail.text, TxtSenhaNova.text)
								web:recoverPublicacaoIdWS(codigoUser)
								
							else
								alert = native.showAlert("Não foi possível cadastrar","Nova senha invalida", {"ok"} )
							end
						else
							alert = native.showAlert("Não foi possível cadastrar","Email invalido", {"ok"} )
						end
					else
						alert = native.showAlert("Não foi possível cadastrar","A senha antiga não confere", {"ok"} )
					end
				else
					alert = native.showAlert("Não foi possível cadastrar","Senha antiga invalida", {"ok"} )
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
        TxtSenhaNova.isSecure = false
        tempo = timer.performWithDelay(1500,ocultarSenha)
    end
end

function ocultarSenha() -- oculta a senha do usuario
	TxtSenhaNova.isSecure = true
	timer.pause( tempo )
end

function mostrarSenha2( event ) -- mostra a senha do usuario
    if event.phase == "began" then
        TxtSenhaAntiga.isSecure = false
        tempo2 = timer.performWithDelay(1500,ocultarSenha2)
    end
end

function ocultarSenha2() -- oculta a senha do usuario
	TxtSenhaAntiga.isSecure = true
	timer.pause( tempo2 )
end

function scene:show(event)
	if event.phase == "did" then
		TxtNome = native.newTextField(display.contentWidth/2 , display.contentHeight/2 - 175, 200, 25 )
		TxtNome.text = nome

		TxtEmail = native.newTextField(display.contentWidth/2 , display.contentHeight/2 - 125, 200, 25 ) 
		TxtEmail.text = emailUser

		TxtSenhaAntiga = native.newTextField(display.contentWidth/2 , display.contentHeight/2 - 73, 200, 25 )
		TxtSenhaAntiga.isSecure = true

		TxtSenhaNova = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 22, 200, 25 )
		TxtSenhaNova.isSecure = true
	end
end

function scene:hide(event)	
	display.remove(TxtNome)
	display.remove(TxtEmail)
	display.remove(TxtSenhaNova)
	display.remove(TxtSenhaAntiga)
end

function scene:destroy(event)
end

scene:addEventListener( "create", scene ) -- adiciona o evento da funcao de criar 
scene:addEventListener( "show", scene ) -- adiciona o evento da funcao de entre 
scene:addEventListener( "hide", scene ) -- adiciona o evento da funcao de sair
scene:addEventListener( "destroy", scene )-- adiciona o evento da funcao de destruir 

return scene
