
import React, { Component } from 'react';
import {connect} from 'react-redux';
import {fetchTags, selectTag} from '../actions/tagActions'

class TagSelect extends Component {

    state = {
        tagId : null,
    }

    handleChange = (event) => {

        if (event.target.id === "tagSelect"){

            this.props.selectTag(event.target.value);

        }
    } 


    componentDidMount(){
    
        this.props.fetchTags();
    }

    render(){

        let options = [];

        if (this.props.tags){

            this.props.tags.forEach(tag => {

                options.push(<option key = {tag.id} value = {tag.name}>{tag.name}</option>);
                
            })

        }


        return (

            <div >

                <div>
                    <label htmlFor="tagSelect">Task</label>

                    <select id = "tagSelect" onChange = {this.handleChange}
                        defaultValue = {this.props.item?this.props.tag.id:""} 
                        placeholder="Tag"
                        className = "form-control" >

                        <option value = {0} key = {0} >Select...</option>
                        {
                            options
                        }
                    </select>
                </div>

            </div>


        );

    }

}


const mapStateToProps = (state) => {
    return {tags : state.tag.tags}
    
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchTags: () => dispatch(fetchTags()),
        selectTag: (tagName) => dispatch(selectTag(tagName))
    }
    
}


export default connect(mapStateToProps, mapDispatchToProps)(TagSelect);