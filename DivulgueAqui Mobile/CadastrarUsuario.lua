--rest
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

function scene:create(event)

	local grupoCena = self.view 

	display.setDefault("background", 0.3, 0.6, 1)
    
    local titulo = display.newText({text="Formulário",x=display.contentWidth/2,y=display.contentHeight/2 - 230})
    titulo:setFillColor( 1,1,0 )
    titulo.isEditable = true
    titulo.size = 30
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
		x = display.contentWidth/2,
		y = display.contentHeight/2 + 35, 
		fillColor = { default={0.1,0.2,0.5,1}, over={1,0.1,0.7,4} },
        strokeColor = { default={0.1,0.2,0.5,1}, over={0.8,0.8,1,1} },
        strokeWidth = 4,
        shape = "roundedRect",
		onRelease = salvarUsuario
		}
	)

	grupoCena:insert(ButtonCadastrar)  
	--[[
	voltar = display.newImage( "botao-voltar.png", display.contentWidth/2 - 100, display.contentHeight/2 + 120)
    grupoCena:insert( voltar )

    voltar:addEventListener("touch",voltar)]]
end
--[[
function voltar(event)
 if event.phase == "began" then
    print("entrou no voltar")
  end
end
]]
function ValidateSave(response) -- validar salvamento

	if response == 300 then
		print("nao pode")
	elseif response == 200 then
		TxtNome.text = ""
		TxtEmail.text = ""
		TxtSenha.text = ""
		txtUsuario.text = ""
		composer.gotoScene("login")
	end
end

function salvarUsuario(event)
	--print("entrou no botao salvar")
	if event.phase == "ended" then
		local email = TxtEmail.text

		if ( email:match("[A-Za-z0-9%.%%%+%-]+@[A-Za-z0-9%.%%%+%-]+%.%w%w%w?%w?") ) then
			
			if TxtNome.text ~= "" then

				if TxtSenha.text ~= "" then

					if txtUsuario.text ~= "" then

						 web:RegisterUserWS(TxtNome.text, TxtEmail.text, TxtSenha.text, txtUsuario.text)
						
					else
						alert = native.showAlert("não foi possivel Cadastrar","nome de usuario invalido", {"ok"} )
					end
				else
					alert = native.showAlert("não foi possivel Cadastrar","senha invalido", {"ok"} )
				end
			else
				alert = native.showAlert("não foi possivel Cadastrar","nome invalido", {"ok"} )
			end
		else
		   alert = native.showAlert("não foi possivel Cadastrar","email invalido", {"ok"} )
		end
	end

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


