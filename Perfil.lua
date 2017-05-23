local widget =  require ("widget")
local composer = require ("composer")
local scene = composer.newScene()
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
--[[
variavel = login.StoreID()
print(variavel)
]]
function scene:create(event)

	local grupoCena = self.view 
    -- Se achar melhor outro nome, fique a vontade!
	local titulo = display.newText({text = "Status Perfil",x=display.contentWidth/2,y=display.contentHeight/2 - 210 })
	titulo:setFillColor( 1,1,0 )
	titulo.isEditable = true
	titulo.size = 30
	grupoCena:insert(titulo)
	
	LabelNome = display.newText({text="Nome ",x=display.contentWidth/2,y=display.contentHeight/2 - 160})
	LabelNome:setFillColor( 0,1,0 )
	grupoCena:insert(LabelNome)
	

	LabelEmail = display.newText({text="Email ",x=display.contentWidth/2 ,y=display.contentHeight/2 - 100})	
	LabelEmail:setFillColor( 0,1,0 )
	grupoCena:insert(LabelEmail)


	LabelTelefone = display.newText({text="Telefone ",x=display.contentWidth/2,y=display.contentHeight/2  - 40})	
	LabelTelefone:setFillColor( 0,1,0 )
	grupoCena:insert(LabelTelefone)


	LabelSenha = display.newText({text="Senha ",x=display.contentWidth/2,y=display.contentHeight/2 + 20})
	LabelSenha:setFillColor( 0,1,0 )
	grupoCena:insert(LabelSenha)


	ButtonSave =  widget.newButton( {label="Save", x = display.contentWidth/2 - 50, y = display.contentHeight/2 + 80, onPress = alterarDadosUsuario } )
	grupoCena:insert(ButtonSave)

	ButtonLogout =  widget.newButton( {label="Logout", x = display.contentWidth/2 + 50, y = display.contentHeight/2 + 80, onPress = fazerLogout } )
    grupoCena:insert(ButtonLogout)
end

-- Adicionar o ouvinte para o botão Logout!
local function fazerLogout(event)
	composer.gotoScene("Login")
end


local function alterarDadosUsuario( ... )
	--recuperar dados do usuario para alterar
end

function scene:show(event)
	if event.phase == "did" then
		TxtNome = native.newTextField(display.contentWidth/2 + 5, display.contentHeight/2 - 140, 200, 25 ) 
		TxtNome.isEditable = true
		TxtNome.size = 14
		TxtEmail = native.newTextField(display.contentWidth/2 + 5, display.contentHeight/2 - 80, 200, 25 ) 
		TxtEmail.isEditable = true
		TxtEmail.size = 14
		TxtTelefone = native.newTextField(display.contentWidth/2 + 5, display.contentHeight/2 - 20, 200, 25 ) 
		TxtTelefone.inputType = "number"
		TxtSenha = native.newTextField(display.contentWidth/2 + 5, display.contentHeight/2 + 40, 200, 25 ) 
	    TxtSenha.isEditable = true
	    TxtSenha.size = 14
	end
end

function scene:hide(event)	
	display.remove(TxtNome)
	display.remove(TxtEmail)
	display.remove(TxtEmail)
	display.remove(TxtTelefone)
	display.remove(TxtSenha)
end

function scene:destroy(event)
end

scene:addEventListener( "create", scene ) -- adiciona o evento da funcao de criar 
scene:addEventListener( "show", scene ) -- adiciona o evento da funcao de entre 
scene:addEventListener( "hide", scene ) -- adiciona o evento da funcao de sair
scene:addEventListener( "destroy", scene )-- adiciona o evento da funcao de destruir 

return scene
