import React,{useState,useEffect} from 'react'
import axios from 'axios';

function ProjectSection() {
    const [statusValue, setStatusValue] = useState("Done");
    const [projectMembers, setProjectMembers] = useState(["Jane Doe"]);
    const [users, setUsers] = useState(["Alex Smith"]);
    const [memeberFound, setmemeberFound] = useState([]);
    const [dropDownBoxesHeight, setDropDownBoxesHeight] = useState([
        {statusBox: 0},{addColumn:0}, {editRow:0},{inviteBox:0},{filterBox:0}, {sort:0},
        {rowId:0}, {statusIndex:0}
    ]);

    const [oneProject, setoneProject] = useState( {project_id: "",
    title: "",
    description: "",
    tables: [
        {
            tasks:[{}]
        }
    ]
});

    useEffect(() => {
        const projectId = sessionStorage.getItem("projectId");
        const fetchProject = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/project/getSingleProject/${projectId}`);
                setoneProject(response.data);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };
        if(projectId){
            fetchProject();
        }
        return () => {
        }
    }, []);
 
   

    const [tables, settables] = useState([[
        {table_name:"Table Name"}, {tasks:[{task_id:1, title:"",Owner:"",Description:"",Start_date:"",End_date:""},
        {task_id:2, title:"task title",Owner:"Jane Doe",Description:"Item Description",Start_date:"",End_date:""},
         {task_id:3, title:"task title",Owner:"Jane Doe",Description:"Item Description",Start_date:"",End_date:""}
        ]}
    ]]);
   
    const toogleDropDownBoxes=(contentType,height,rowIndex)=>{
        setDropDownBoxesHeight(prevValue => prevValue.map(item=> 
            contentType == 'statusBox' ? {...item,  statusIndex : rowIndex, }: 
            contentType == 'editRow' ?  {...item, rowId: rowIndex}:{...item}
        ))
        setDropDownBoxesHeight(prevValue => prevValue.map(item=> 
            item[contentType] ? {...item, [contentType] : 0}: {...item, [contentType] : height}
        ))
    } 

    const createTable=()=>{
        const newTable = tables[0];
        settables([...tables,newTable])
    }
    const showSearchedMember=(e)=>{
        const memberPresent = users.filter(name=>
            name.includes(e.target.value)
        )
        memberPresent.length > 0 && e.target.value !== "" ?setmemeberFound(memberPresent):setmemeberFound([]);
    }
    const addMemberToProject=(newMember)=>{
        setProjectMembers(prevItems =>[...prevItems,newMember])
    }   
  return (
    <>
        <div className="project-section">
            <div className="container">
                <div className="comment_wrapper">
                    <i className="lni lni-close"></i>
                    <h6 id="comment_section_title">Comments on the front end project </h6>
                    <div className="comment-section">
                        <form action="">
                            <textarea placeholder='Please type your comment here' name="" id="" cols="30" rows="7"></textarea>
                            <div className="comment-buttons">
                                <div className="letter_buttons">
                                    <span>B</span>
                                    <span>l</span>
                                    <span>U</span>
                                </div>
                                <button><i className="lni lni-comments-alt-2"></i> Comment</button>
                            </div>
                        </form>
                        <div className="user_comment_thread">
                            <h6 className='comments_size'>12 Comments</h6>
                            <div className="comment_details">
                            <div><span id="user_letter">D</span></div>
                                <div className="user_massage">
                                    <span id="user_name">Jane Doe</span>
                                    <span id='comment_time'>7 hours Ago</span>
                                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Voluptatem repellendus beatae reiciendis facere 
                                    tenetur minus, ab nisi ipsam, accusamus quis.</p>
                                </div>
                            </div>
                            <div className="comment_details">
                            <div><span id="user_letter">J</span></div>
                                <div className="user_massage">
                                    <span id="user_name">Jane Doe</span>
                                    <span id='comment_time'>7 hours Ago</span>
                                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Voluptatem repellendus beatae reiciendis facere 
                                    tenetur minus, ab nisi ipsam, accusamus quis.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <h6 className='page-section-header'>{oneProject.title}</h6>
                <div className="filter_project_section">
                    <div className="page-row project_filter_row">
                        <div className="table-filters">
                            <div className="page-row">
                                <form action="" className='table_filter_col'>
                                    <i className="lni lni-search"></i>
                                    <input placeholder='Search' type="text"/>
                                </form>
                                <div className="peron_filter table_filter_col">
                                    <i className="lni lni-users"></i>
                                    <p onClick={()=>toogleDropDownBoxes("filterBox",100,0)}>Filter by person</p>
                                    <div style={{height:dropDownBoxesHeight[4].filterBox}} className="person_filter_box">
                                        <div className="filter_person_wrapper">
                                            <h6>Select member to filter with:</h6>
                                            {projectMembers.map((name,i)=>
                                            <p>{name}</p>
                                            )}
                                        </div>
                                    </div>
                                </div>
                                <div className="filter_sort table_filter_col">
                                    <i class="lni lni-sort-alpha-asc"></i>
                                    <p>Sort</p>
                                </div>
                            </div>
                        </div>
                        <div className="project_create_table_invite">
                            <div className="project_members">
                                {projectMembers.map((name,i)=>
                                   <span>{name.charAt(0)}</span>
                                )}
                            </div> 
                            <div  className="invite_btn">
                                <p onClick={()=>toogleDropDownBoxes("inviteBox", 250,0)}>invite <i class="lni lni-circle-plus"></i></p>
                                <div style={{height: dropDownBoxesHeight[3].inviteBox}} className="invite_members">
                                   <div className="member_invite_wrapper">
                                        <h5>Search members to add by name  </h5>
                                        <form action=""> <input onChange={(e)=>showSearchedMember(e)} type="text" placeholder='Please search member' /><input type="submit" value="search"/></form>
                                        {memeberFound.map((memberName,i)=>
                                        <p onClick={()=>addMemberToProject(memberName)} >{memberName}</p>
                                        )}
                                        <h6>List of project members</h6>
                                        {
                                            projectMembers.map((names,index)=>
                                            <p>{names}</p>
                                            )
                                        }
                                   </div>
                                </div>
                            </div>   
                            <button onClick={createTable}>
                                <i class="lni lni-layers"></i>
                                <span>create table</span>
                            </button>
                        </div>
                    </div>
                </div>
                {
                  oneProject.tables.map((table,table_index)=>
                        <div className="table_section">
                            <h6 id='table_title'>{table.table_name}</h6>
                            <div className="project_table">
                                <div className="page-row col_name_row">
                                    <div style={{height:dropDownBoxesHeight[1].addColumn}}  className="add-table-column">
                                        <h6>Add extra table columns:</h6>
                                        <p>
                                            <i className="lni lni-comments-alt-2"></i>
                                            <span>Comment</span>
                                        </p>
                                        <p>
                                            <i className="lni lni-sort-alpha-asc"></i>
                                            <span>Priority</span>
                                        </p>
                                    </div>
                                    <span className='field_name col_name'>Title</span>
                                    <span className='field_name col_name'>Description</span>
                                    <span className='field_name col_name'>Owner</span>
                                    <span className='field_name col_name'>start-date</span>
                                    <span className='field_name col_name'>end-date</span>
                                    <span className='field_name col_name'>status</span>
                                    <div className='more  more-col' onClick={()=>toogleDropDownBoxes("addColumn", 160)}> <i className="lni lni-more"></i></div>
                                </div>
                            {
                            table.tasks.map((task,taskIndex)=>
                              <div>
                                  <div  className="page-row table_task_row">
                                    <div style={{height:dropDownBoxesHeight[6].rowId == task.task_id ? dropDownBoxesHeight[2].editRow : 0 }} className="edit_task_box">
                                        <div className="box-arrow"></div>
                                        <p>
                                            <i className="lni lni-trash-can"></i>
                                            <span>Delete</span>
                                        </p>
                                        <p>
                                            <i className="lni lni-clipboard"></i>
                                            <span>Duplicate</span>
                                        </p>
                                        <p>
                                        <i className="lni lni-circle-plus"></i>
                                            <span>Delete</span>
                                        </p>
                                    </div>
                                    <span className='field_name text_task table-task task-title'><i onClick={()=>toogleDropDownBoxes('editRow', 160, task.task_id)} className="more-task lni lni-more"></i> <span>{task.title}</span> </span>
                                    <span className='field_name table-task text_task'>{task.Description}</span>
                                    <span className='field_name table-task text_task' >{task.Owner}</span>
                                    <div className='field_name table-task'><input type="date"/></div>
                                    <div  className='field_name table-task'><input type="date"/></div>
                                    <div onClick={()=>toogleDropDownBoxes("statusBox", 160, task.task_id)} id={statusValue} className='status field_name table-task'>
                                        {statusValue}
                                        <div style={{height:dropDownBoxesHeight[7].statusIndex == task.task_id ? dropDownBoxesHeight[0].statusBox : 0}} className="status_dropdown">
                                            <div className="status_dropdown_content">
                                                <span id='Done'>Done</span>
                                                <span id='ToDo'>To Do</span>
                                                <span id='InProgress'>In Progress</span>
                                            </div>
                                        </div>
                                   </div>
                                   <div className='more'></div>
                                </div>       
                              </div>                     

                            )
                        }
                        
                    </div>
                </div>
                  )
                  
                    
                }
            </div>
        </div>
    </>
  )
}

export default ProjectSection