// let's extend HTMLElement 
var MyElementComponentProto = Object.create(HTMLElement.prototype); 

// and add some template using a lifecycle 
MyElementComponentProto.createdCallback = function() { 
	this.innerHTML = '<h1>Hello web component developpers</h1><style>h1 {color:red;}</style>';
};

// new element 
var MyElementComponent = document.registerElement('my-element-simple', {prototype: MyElementComponentProto}); 
// insert in current body 
document.body.appendChild(new MyElementComponent());

//----------------- Element with shadow DOM -------------------
// let's extend HTMLElement 
var MyElementComponentWithShadowDOMProto = Object.create(HTMLElement.prototype); 

// and add some template using a lifecycle 
MyElementComponentWithShadowDOMProto.createdCallback = function() { 
	// Create shadow DOM for element
	var shadow = this.createShadowRoot()  
	// add some template in the Shadow DOM
	shadow.innerHTML = '<h1>Hello web component developpers with shadow DOM</h1><style>h1 {color:orange;}</style>';
};

// new element 
var MyElementComponentWithShadowDOM = document.registerElement('my-element-shadow', {prototype: MyElementComponentWithShadowDOMProto}); 
// insert in current body 
document.body.appendChild(new MyElementComponentWithShadowDOM());

//----------------- Element with shadow DOM and template-------------------
// let's extend HTMLElement 
var MyElementComponentWithShadowDOMAndTemplateProto = Object.create(HTMLElement.prototype); 

// add some template using the template tag 
MyElementComponentWithShadowDOMAndTemplateProto.createdCallback = function() { 
	var template = document.querySelector('#template-id'); 
	var clone = document.importNode(template.content, true);
	// Create shadow DOM for element
	var shadow = this.createShadowRoot()  
	// add some template in the Shadow DOM
	shadow.appendChild(clone); 
};

// new element 
var MyElementComponentWithShadowDOMAndTemplate = document.registerElement('my-element-shadow-templated', {prototype: MyElementComponentWithShadowDOMAndTemplateProto}); 
// insert in current body 
document.body.appendChild(new MyElementComponentWithShadowDOMAndTemplate());