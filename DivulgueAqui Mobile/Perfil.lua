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
local TxtSenha
local ButtonSave 
local ButtonLogout

function scene:create(event)

	local grupoCena = self.view 


	display.setDefault("background", 0.3, 0.6, 1)

    -- Se achar melhor outro nome, fique a vontade!
	local titulo = display.newText({text = "Status Do Perfil",x=display.contentWidth/2,y=display.contentHeight/2 - 250 })
	titulo:setFillColor( 1,1,0 )
	titulo.isEditable = true
	titulo.size = 30
	grupoCena:insert(titulo)
	
	LabelNome = display.newText({text="Nome ",x=display.contentWidth/2,y=display.contentHeight/2 - 225})
	LabelNome:setFillColor( 0,1,0 )
	grupoCena:insert(LabelNome)
	

	LabelEmail = display.newText({text="Email ",x=display.contentWidth/2 ,y=display.contentHeight/2 - 173})	
	LabelEmail:setFillColor( 0,1,0 )
	grupoCena:insert(LabelEmail)

	LabelSenha = display.newText({text="Senha ",x=display.contentWidth/2,y=display.contentHeight/2 - 122})
	LabelSenha:setFillColor( 0,1,0 )
	grupoCena:insert(LabelSenha)


	ButtonSave =  widget.newButton( 

		{
		label="Save",
		x = display.contentWidth/2 + 5,
		y = display.contentHeight/2 - 50,
		onRelease = updateUser,
        strokeWidth = 4,
        shape = "roundedRect" 
		
		}
	)
	grupoCena:insert(ButtonSave)
end

function confirmacaoDeAtualizacaoDoUsuario(codigo)
	
		if codigo == 200 then
			alert = native.showAlert("informação","usuario alterado com sucesso!", {"ok"} )
			nome = TxtNome.text
			emailUser = TxtEmail.text
			web:recoverPublicacaoIdWS(codigoUser)
			composer.gotoScene("Logado")
		else
			alert = native.showAlert("erro","não foi possivel alterar o usuario. Se o problema persistir entre em contato conosco em suporte.divulgueaqui@gmail.com", {"ok"} )
		end
end

function updateUser(event)

	if event.phase == "ended" then
		local email =  TxtEmail.text
		
		if  TxtNome.text ~= "" then

			if  ( email:match("[A-Za-z0-9%.%%%+%-]+@[A-Za-z0-9%.%%%+%-]+%.%w%w%w?%w?") ) then

				if TxtSenha.text ~= "" then
					web:updateUserWS(codigoUser, TxtNome.text, TxtEmail.text, TxtSenha.text)
					web:recoverPublicacaoIdWS(codigoUser)
					
				else
					alert = native.showAlert("não foi possivel Cadastrar","senha invalido", {"ok"} )
				end
			else
				alert = native.showAlert("não foi possivel Cadastrar","email invalido", {"ok"} )
			end
		else
			alert = native.showAlert("não foi possivel Cadastrar","preencha o campo nome", {"ok"} )
		end		
	end
end

function scene:show(event)
	if event.phase == "did" then
		TxtNome = native.newTextField(display.contentWidth/2 + 5, display.contentHeight/2 - 200, 200, 25 )
		TxtNome.text = nome

		TxtEmail = native.newTextField(display.contentWidth/2 + 5, display.contentHeight/2 - 150, 200, 25 ) 
		TxtEmail.text = emailUser
		
		TxtSenha = native.newTextField(display.contentWidth/2 + 5, display.contentHeight/2 - 100, 200, 25 )
		TxtSenha.isSecure = true
	end
end

function scene:hide(event)	
	display.remove(TxtNome)
	display.remove(TxtEmail)
	display.remove(TxtSenha)
end

function scene:destroy(event)
end

scene:addEventListener( "create", scene ) -- adiciona o evento da funcao de criar 
scene:addEventListener( "show", scene ) -- adiciona o evento da funcao de entre 
scene:addEventListener( "hide", scene ) -- adiciona o evento da funcao de sair
scene:addEventListener( "destroy", scene )-- adiciona o evento da funcao de destruir 

return scene
