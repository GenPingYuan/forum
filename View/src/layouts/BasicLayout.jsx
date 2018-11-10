import React,{PureComponent} from 'react'
import Head from '../pages/components/Head'

class BasicLayout extends PureComponent{
    constructor(props){
        super(props);
    }

    render(){
        return(
            <div>
                <div><Head/></div>
                <div>{this.props.children}</div>
            </div>
        )
    }

}

export default BasicLayout