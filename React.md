## Basics

1. React Component : Code that represents html portion
2. ReactDOM : ReactDOM interacts with DOM elements directly  
3. Class vs functional compoenents : 
4. JSX : HTML looking code which works inside JS
5. State: 
`
this.setState(prevState=>{
    return {
        isMusicPlaying: !prevState.isMusicPlaying
    };
});
`
6. Refs: Actual reference to elements


## LifeCycle Events

### Mounting

1. Constructor (props,state) 
  Desc: When Mounting First Method Called, 
  Uses: createRef, Init Set State, Method Bind

2. getDerivedStateFromProps(props,state)
Desc: Static Method.When Mounting Last Method Called Before Rendering 
Uses: Init Set State

3. render
Desc: does all the work, 
Uses: returns JSX of component

4. componentDidMount
Desc: After component gets rendered, this is called. 
Uses:make ajax calls, DOM updates, add event listeners

### Updating

1. getDerivedStateFromProps (props,state)
Desc: Static method with no access to refs or the component.
Uses:Updating state based on props, when props are not enough
2. shouldComponentUpdate: (nextProps,nextState) 
Desc: Controlling when component re-renders 
Uses: Perf improvement
3. render 
Desc: does all the work, 
Uses: returns JSX of component
4. getSnapShotBeforeUpdate: between render and DOM update,
Uses: pass attribute of DOM to componentDidUpdate
5. componentDidUpdate (prevProps,prevState,snapshot) 
Desc: changes have been updated to DOM, 
Uses: react to DOM changes

### UnMounting

1.componentWillUnmount
Desc: Last method of component lifecycle,
Uses:cancel network requests, remove event listeners, clear intervals, clean up


### Errors
 
1.getDerivedStateFromError(error)  
Desc: used When error in children,
Uses: update state to display error screen

2.componentDidCatch(error,info) 
Desc: used when error in children, 
Uses:catching and logging errors. 
Note:This logs errors in lifecycle methods and not in click Handlers 


## Fiber

### Algorithm

1. Reconcilation Phase

    1. Update State
    2. Update Props
    3. Call lifecycle methods
    4. Update refs

2. Commit Phase

    1. Making updates to DOM

### Fiber Data Structure

During reconcilation data from every React element returned from the render method i smerged into a tree of fiber nodes. Every React element has a corresponding fiber node that describes the work that needs to be done. Unlike React elements fibers aren't re-created on every render. These are mutable data structures that hold components state and DOM.  

When a React element is converted into a fiber node for the first time, React uses the data from the element to create a fiber node. In the consequent updates, React reuses the fiber node and just updates the necessary properties using the data from a corresponding React element. React may move the node around based on the key property or may even delete it if it is no longer returned from the render method.

Because React creates a fiber for each React element and since we have a tree of those elements, we have a tree of fiber nodes. All fiber nodes are connected using the following properties: child, sibling and return.

The structure has 3 fields -
1.  child - reference to the first child
2.  sibling - reference to the first sibling
3.  return - reference to the parent

`class Node {
    constructor(instance) {
        this.instance = instance;
        this.child = null;
        this.sibling = null;
        this.return = null;
    }
}
`
After the first render, React ends up with a fiber tree which represents the state of the application that is used to render the UI. This tree is called current. When react starts working on updates it builds a so-called workInProgress tree that reflects the future state to be flushed to screen. All work is performed on the fibers from the workInProgress tree. This node is created using the data from React elements returned by the render method. Once the updates are processed and all related work is completed, React will have an alternate tree ready to be flushed to screen.Once this workInProgress tree is flushed to screen, it becomes the current tree. 

React always updates DOM in one go - it doesn't show partial results.The workInProgress tree serves as a “draft” that’s not visible to the user, so that React can process all components first, and then flush their changes to the screen. 

### Side Effects

A component is a function that uses props and state to compute UI representation. Every other activity like mutating the DOM or calling lifecycle methods should be considered a side effect/effects. Most props and state updates will lead to side-effects. A fiber node is a convenient mechanism, to track effects in addition to updates.Each fiber node can have effects associated with it. They are encoded in the effectTag field.

### Motivation

render() function renders a tree of React elements on every props/state update. React efficiently updates UI to match the most recent tree. React implements a heuristic O(n) algorithm based on 2 assumptions:
    a. Two elements of different types will produce different trees
    b. The developer can hint at which child elements are stable by using a key prop.

## The Diffing Algorithm

### Elements of different types

React compares the root elements and if they are of different types (<a> vs <img>) - old tree is torn down and new one is built from scratch. Component instances receive componentWillUnmount() and new DOM nodes are inserted and new component instances receive componentWillMount() and then componentDidMount(). Any state associated with the old tree is lost. Any components below the root will also be unmounted and their state destroyed.

### DOM Elements of same type

When comparing two React DOM elements of the same type, React looks at the attributes of both, keeps the same DOM node and updates only the changed attributes. After handling the DOM node, React recurses on the children.

### Components of same type

When a component updates, the instance stays the same so that state is maintained across renders. React updates the props of the underlying component instance to match the new element and calls componentWillReceiveProps() and componentWillUpdate() on the underlying instance.

### Recursing on Children

<ul>                            <ul>                                                                                           
    <li>first</li>                  <li>first</li>                
    <li>second</li>                 <li>second</li>
</ul>                               <li>third</li>
                                </ul>

This comparision is easier as React iterates over both lists of children at the same time and generates a mutation when a diff is found

<ul>                            <ul>                                                                                           
    <li>first</li>                  <li>third</li>                
    <li>second</li>                 <li>first</li>
</ul>                               <li>second</li>
                                </ul>

This comparision is more difficult as React mutates every child instead of realizing that the bottom two elements can be kept intact.
This issue is solved by children having keys, Reacat uses the key to match the children in original tree with children in the subsequent tree.
